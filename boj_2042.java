
// 어떤 N 개의 수가 주어져있다. 
// 중간에 수의 변경이 빈번히 일어난다.
// 그 중간에 어떤 부분의 합을 구하려한다. 
// 1~5 수가 있고 3번쨰수를 수를 변경하고 구간합. 
// 누적합으로는 N 만큼 들지.

// 시간복잡도
// N 은 100만
// M 은 1만
// K 는 1만

// 누적합으로 처리하기에는 변경을 1만개나 한다고 하니. 불가능. 
// 구간의 합을 구하는 횟수도 주어진다. 
// a 가 1인경우에는 b번째수를 c로 바꾼다. 
// a 가 2인경우에는 b~c 의 구간합을 구한다. 
// long 을 사용해야함. 
// 구간합을 log n 에 처리가능, 변경도 log n 에 처리가능.
// 입력과 출력. 

import java.io.*;
import java.util.*;

public class boj_2042 {
    static long[] arr;         // 원본 배열 (1-based index)
    static long[] tree;        // 세그먼트 트리 배열
    static int N;              // 원소 개수

    public static void main(String[] args) throws IOException {
        // 1. 입력을 빠르게 받기 위한 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 2. 배열 크기 및 쿼리 수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    // 배열 길이
        int M = Integer.parseInt(st.nextToken()); // update 개수
        int K = Integer.parseInt(st.nextToken()); // query 개수

        arr = new long[N + 1];      // 배열 1-based
        tree = new long[N * 4];     // 세그먼트 트리 크기 넉넉히

        // 3. 배열 값 입력
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 4. 세그먼트 트리 초기화
        init(1, 1, N);

        // 5. 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 1: update, 2: sum
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // arr[b] = c 로 변경
                update(1, 1, N, b, c);
            } else if (a == 2) {
                // b~c 구간 합
                sb.append(query(1, 1, N, b, (int) c)).append("\n");
            }
        }

        // 6. 출력
        System.out.print(sb);
    }

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node*2 + 1 , mid+1, end);
        tree[node] = tree[node * 2] + tree[node*2 + 1];
    }
    
    public static void update(int node, int start, int end , int index, long value){
        if(index < start || index > end) return;
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1 , end, index, value);
        tree[node] = tree[node*2] + tree[node*2 + 1];
    }

    public static long query(int node, int start, int end, int left, int right){
        if(right < start || left > end ) return 0;
        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        long L = query(node * 2, start, mid, left, right);
        long R = query(node * 2+1, mid + 1, end, left, right);
        return L + R;
    }

}

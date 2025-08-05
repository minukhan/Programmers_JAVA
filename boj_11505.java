import java.util.*;
import java.lang.*;
import java.io.*;

// 10 : 25

// 어떤 N 개의 수가 주어져있다. 
// 수의 변경이 빈번히 일어나고 중간에 어떤 부분의 곱을 구하려한다. 
// N 이 100만개. nlogn으로 풀어야함. 
// 변경이 1만번
// 곱을 구하는 횟수 1만번. 
// 구간의 곱을 10억 저걸로 나눠야한다. 
// 변경도 일어나고 구간의 작업을 처리해야한다? -> 세그먼트 트리. 
class boj_11505 {

    public static int define = 1_000_000_007;

    public static long[] arr;
    public static long[] tree;
    public static int N;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[4 * N];

        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1,1,N);
        
        for(int i=0;i<M + K;i++){
            st = new StringTokenizer(br.readLine());

            int find = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(find == 1){
                // b를 c로 바꾸는 로직
                update(1,1,N,first, second);
            }
            else{
                // b부터 c까지의 곱 로직

                long result = query(1,1,N,first,second);

                System.out.println(result);
            }
        }
    }

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2 , start, mid);
        init(node * 2 + 1 , mid + 1 , end);
        tree[node] = (tree[node*2] % define) * (tree[node*2 + 1] % define) % define;
    }

    public static void update(int node, int start, int end, int index, int value){

        if(index < start || index > end) return;
        
        if(start == end){
            tree[node] = value;
            return;
        }
        
        int mid = (start + end) / 2;
        
        update(node * 2 , start, mid, index, value);
        update(node * 2 + 1 , mid + 1 , end, index, value);
        tree[node] = (tree[node*2] % define) * (tree[node*2 + 1] % define) % define;
    }

    public static long query(int node, int start, int end, int left, int right){
        if(right < start || left > end) return 1;
        if(left <= start && right >= end) return tree[node];
        
        int mid = (start + end) / 2;

        long L = query(node * 2 , start, mid, left, right);
        long R = query(node * 2 + 1 , mid + 1 , end, left, right);
        return (L * R) % define;
    }
}

























import java.util.*;
import java.lang.*;
import java.io.*;

// 9 : 40

// N 10만개
// a부터 b 까지 제일 작은 정수, 제일 큰 정수를 찾는것은 어려운 일이 아니다. 
// 10만개가 주어짐. 
// 먼저 완탐부터 생각해봄
// 이때 10 * 10 만 이기때문에 터짐.
// 그러면 누적합? 구간의 합은 누적합으로도 했으니까
// 근데 이게 횟수가 10만번인데. 상관없긴한데 최소, 최대를 찾아야함.
// 그 이후결과를 얻는거면 가능한데.
// 그래서 세그먼트 트리를 사용해야함. 구간합을 트리형태로 저장하고있어서 
// log n 만큼 접근할 수 있음. 그걸 다 돌리면 query 를 돌려서 접근하면 되는듯.?


class boj_2357 {
    public static int[] maxTree;
    public static int[] minTree;
    public static int N;
    public static int M;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        maxTree = new int[4 * N];
        minTree = new int[4 * N];
        
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        maxInit(1,1,N);
        minInit(1,1,N);
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int maxResult = maxQuery(1, 1, N, start, end);
            int minResult = minQuery(1, 1, N, start, end);

            sb.append(minResult).append(" ").append(maxResult).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void maxInit(int node, int start, int end){

        if(start == end){
            maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end )/ 2;
        maxInit(node * 2, start, mid);
        maxInit(node * 2+1, mid +1, end);

        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2+1]);
    }
    
    public static int maxQuery(int node, int start, int end, int left, int right){
        if(right < start || left > end) return Integer.MIN_VALUE;
        if(left <= start && right >= end) return maxTree[node];
        
        int mid = (start + end )/ 2;
        int L = maxQuery(node * 2, start, mid, left, right);
        int R = maxQuery(node * 2+1, mid +1, end, left, right);
         
        return Math.max(L, R);
    }

    public static void minInit(int node, int start, int end){

        if(start == end){
            minTree[node] = arr[start];
            return;
        }

        int mid = (start + end )/ 2;
        minInit(node * 2, start, mid);
        minInit(node * 2+1, mid +1, end);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2+1]);
    }

    

    public static int minQuery(int node, int start, int end, int left, int right){
        if(right < start || left > end) return Integer.MAX_VALUE;
        if(left <= start && right >= end) return minTree[node];
        
        int mid = (start + end )/ 2;
        int L = minQuery(node * 2, start, mid, left, right);
        int R = minQuery(node * 2+1, mid +1, end, left, right);
         
        return Math.min(L, R);
    }
}
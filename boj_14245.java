import java.util.*;
import java.lang.*;
import java.io.*;


// 12 : 10
// 수열이 주어진다. 
// 특정구간 a~b 에 c를 xor 한ㄷ.ㅏ
// 이게 다른점은 그 구간의 값을 구하는게 아니라 그 구간의 update를 해줘야함.
// a번째 원소의 값을 출력한다. 
// 이게 query리고
// 수열의 크기가 50만
// 
class boj_14245 {
    public static int[] arr;
    public static int[] tree;
    public static int[] lazy;
    public static int N;
    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        lazy = new int[N* 4];
        tree = new int[N * 4];
        
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());        
        }

        int M = Integer.parseInt(br.readLine());
        init(1,1,N);
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());

            if(check == 1){
                int start = Integer.parseInt(st.nextToken()) + 1;
                int end = Integer.parseInt(st.nextToken()) + 1;
                int value = Integer.parseInt(st.nextToken());

                update(1,1,N,start, end, value);
                
            }
            else{
                int index = Integer.parseInt(st.nextToken())+1;

                int result = query(1,1,N,index);
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

        init(node*2, start, mid);
        init(node*2+1, mid+1, end);
        tree[node] = tree[node*2] ^ tree[node * 2 +1];
    }

    public static void update(int node, int start, int end, int L, int R, int value){

        // 쫙 실행하는 코드.
        spread(node, start, end);
        
        if(L > end || R < start) return;
        if(L <= start && R >= end){
            // lazy에 기록하는로직.
            lazy[node] = lazy[node] ^ value;
            spread(node, start, end);
            // 쫙 실행하는 코드
            return;
        }


        int mid = (start + end) / 2;

        update(node*2, start, mid, L, R, value);
        update(node*2+1, mid+1, end, L, R, value);
        tree[node] = tree[node*2] ^ tree[node * 2 +1];
    }

    public static int query(int node, int start, int end, int index ){

        // 쫙 퍼트리는 로직
        spread(node, start, end);
        
        if(start == end){
            return tree[node];
        }

        int mid = (start + end) / 2;

        if(index <= mid) return query(node * 2 , start, mid, index);
        else return query(node * 2 + 1, mid+1, end, index);
    }

    public static void spread(int node, int start, int end){

        if(lazy[node] == 0) return;

        int len = end - start + 1;

        if(len % 2 == 1){
            tree[node] = tree[node] ^ lazy[node];
        }

        if(start != end){
            lazy[node * 2] = lazy[node * 2] ^ lazy[node];
            lazy[node * 2+1] = lazy[node * 2+1] ^ lazy[node];
        }

        lazy[node] = 0;
    }
}






















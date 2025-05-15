import java.util.*;
import java.lang.*;
import java.io.*;


class boj_1717 {
    public static int N;
    public static int M;
    public static int[] parent;

    public static void makeSet(){
        parent = new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i] = i;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        makeSet();
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(index == 0) union(first, second);
            if(index == 1){
                if(find(first) == find(second)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        
    }
    

    public static int find(int number){
        if(parent[number] != number){
            parent[number] = find(parent[number]);
        }
        
        return parent[number];
    }
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return;
        }

        parent[rootB] = rootA;
    }
}
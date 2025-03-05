import java.util.*;
import java.lang.*;
import java.io.*;

class FindParentTree {
    public static ArrayList<Integer>[] tree;
    public static boolean[] visited;
    public static int[] count;
    public static StringBuilder sb;
    
    
    public static void FindParentTree(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N= Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            tree[i] = new ArrayList<Integer>();
        }
        StringTokenizer st;
        sb = new StringBuilder();
        
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            tree[from].add(to);
            tree[to].add(from);
        }

        visited = new boolean[N+1];
        count = new int[N+1];

        bfs();

        for(int i=2;i<count.length;i++){
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;
        count[1] = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int value : tree[node]){

                if(visited[value]) continue;
                
                queue.add(value);
                visited[value] = true;
                count[value] = node;
            }
        }
    }
}
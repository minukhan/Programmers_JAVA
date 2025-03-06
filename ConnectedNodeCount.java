import java.util.*;
import java.lang.*;
import java.io.*;

class ConnectedNodeCount {

    public static boolean[] visited;
    public static int count=0;
    public static ArrayList<Integer>[] graph;
    
    public static void ConnectedNodeCount(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<M+1;i++){
            st= new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        visited = new boolean[N+1]; 

        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int value : graph[node]){
                if(visited[value]) continue;

                queue.add(value);
                visited[value] = true;
            }
        }
    }
}
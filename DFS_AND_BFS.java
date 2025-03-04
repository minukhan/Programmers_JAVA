import java.util.*;
import java.lang.*;
import java.io.*;

class DFS_AND_BFS {

    public static boolean[] visited;
    public static StringBuilder sb ;
    public static ArrayList<Integer>[] graph;
    
    public static void DFS_AND_BFS(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        // 그래프 초기화
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        // 간선들 추가
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to); 
            graph[to].add(from); 
        }

        visited = new boolean[N+1];

        for(int i=1;i<N+1;i++){
            graph[i].sort(Comparator.naturalOrder());
        }

        dfs(V);

        sb.append("\n");
        for(int i=1;i<N+1;i++){
            visited[i] = false;
        }

        
        bfs(V);

        System.out.println(sb.toString());
        
        
    }
    public static void dfs(int x){
        visited[x] = true;
        sb.append(x).append(" ");
        for(int node : graph[x]){
            if(visited[node]) continue;

            dfs(node);
        }
    }

    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;
        sb.append(x).append(" ");
        
        while(!queue.isEmpty()){

            int node = queue.poll();
            
            for(int value : graph[node]){
                if(visited[value]) continue;
                sb.append(value).append(" ");
                queue.add(value);
                visited[value] = true;
            }
        }
    }

}
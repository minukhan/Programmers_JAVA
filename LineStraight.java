import java.util.*;
import java.lang.*;
import java.io.*;

class LineStraight {

    public static int[] inDegree;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static StringBuilder sb;
    
    public static void LineStraight(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();       
        }

        inDegree = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=1;i<M+1;i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            graph[from].add(to);
            inDegree[to]++;
        }

        sb = new StringBuilder();
        bfs();
        System.out.println(sb.toString());
        
    }

    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
                visited[i] = true;
                sb.append(i).append(" ");
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int value: graph[node]){

                if(visited[value]) continue;
                
                inDegree[value]--;
                if(inDegree[value] == 0){
                    queue.add(value);
                    visited[value] = true;
                    sb.append(value).append(" ");
                }
            }
        }
    }

}
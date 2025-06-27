import java.util.*;
import java.lang.*;
import java.io.*;

class boj_10282 {

    static class Edge{
        int index;
        int time;
        public Edge(int index, int time){
            this.index = index;
            this.time = time;
        }
    }
    
    static class Node{
        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    public static int N;
    public static int D;
    public static int C;
    public static ArrayList<Edge>[] graph;
    public static int[] dist;
    public static int DEFINEMAX = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
    
            graph = new ArrayList[N+1];
    
            for(int i=0;i<N+1;i++){
                graph[i] = new ArrayList<>();
            }
            dist = new int[N+1];
    
            Arrays.fill(dist, DEFINEMAX);
            
            for(int i=0;i<D;i++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
            
                graph[from].add(new Edge(to, time));
            }
    
            dijkstra();
    
            int count=0;
            int max = Integer.MIN_VALUE;
    
            // for(int i=1;i<N+1;i++){
            //     System.out.println( i + " : " + dist[i] + " ");
            // }
            
            for(int i=1;i<N+1;i++){
                if(dist[i] != DEFINEMAX){
                    count++;
                    max = Math.max(max, dist[i]);
                }
            }
    
            StringBuilder sb = new StringBuilder();
    
            sb.append(count).append(" ").append(max);
            System.out.println(sb.toString());
        }
        
    }

    public static void dijkstra(){

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.dist, o2.dist)
        );
        queue.add(new Node(C,0));
        dist[C] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[node.index]) continue;

            for(Edge e : graph[node.index]){

                if(dist[node.index] + e.time < dist[e.index]){
                    dist[e.index] = dist[node.index] + e.time;
                    queue.add(new Node(e.index, dist[e.index]));
                }
            }
        }
    }
}
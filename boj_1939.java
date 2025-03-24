import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1939 {

    static class Edge{
        int to;
        int we;
        public Edge(int to,int we){
            this.to = to;
            this.we = we;
        }
    }
    static class Node{
        int index;
        int dist;
        public Node(int index,int dist){
            this.index = index;
            this.dist = dist;
        }
    }
    public static int[] dist;
    public static ArrayList<Edge>[] graph;
    
    public static void boj_1939(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }
        
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start){

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o2.dist - o1.dist);

        queue.add(new Node(start, Integer.MAX_VALUE));
        dist[start] = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[node.index]) continue;

            for(Edge edge: graph[node.index]){
                int newCapacity = Math.min(dist[node.index], edge.we);
                if(dist[edge.to] >= newCapacity) continue;
            
                dist[edge.to] = newCapacity;
                queue.add(new Node(edge.to, dist[edge.to]));
            }
        }
    }
}
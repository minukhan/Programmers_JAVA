import java.util.*;
import java.lang.*;
import java.io.*;

class boj_14284 {

    public static ArrayList<Edge>[] list;
    public static int N;
    public static int M;
    public static int end;
    public static int[] dist;

    static class Edge{
        int index;
        int weight;
        public Edge(int index, int weight){
            this.index = index;
            this.weight = weight;
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
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to,weight));
            list[to].add(new Edge(from,weight));
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dijkstra(start);
        
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.dist,o2.dist)
            );

        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] != node.dist) continue;
            
            for(Edge e : list[node.index]){
                if(dist[e.index] > node.dist + e.weight){
                    dist[e.index] = node.dist + e.weight;
                    queue.add(new Node(e.index, node.dist + e.weight));
                }
            }
        }
    }
}





























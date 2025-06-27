import java.util.*;
import java.lang.*;
import java.io.*;


class boj_14938 {

    public static ArrayList<Edge>[] graph;
    public static int N;
    public static int M;
    public static int R;
    public static int DEFINEMAX = Integer.MAX_VALUE;
    public static int[] we;
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
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        we = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            we[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        Arrays.fill(dist, DEFINEMAX);
        
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to,weight));
            graph[to].add(new Edge(from,weight));
        }

        int answer=0;
        int max = Integer.MIN_VALUE;
        

        for(int i=1;i<N+1;i++){
            Arrays.fill(dist, DEFINEMAX);
            dijkstra(i);
            answer = 0;
            
            for(int j=1;j<N+1;j++){
                if(dist[j] != DEFINEMAX && dist[j] <= M){
                    answer = answer + we[j];
                }
            }
            
            max = Math.max(max,answer);
        }
        
        System.out.println(max);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node =queue.poll();

            if(node.dist != dist[node.index]) continue;

            for(Edge e : graph[node.index]){

                if(dist[node.index] + e.weight < dist[e.index]){
                    dist[e.index] = dist[node.index] + e.weight;
                    queue.add(new Node(e.index, dist[e.index]));
                }
            }
        }
    }
}
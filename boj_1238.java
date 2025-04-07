import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1238 { // 11:06

    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
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
    
    public static int N;
    public static int M;
    public static int X;
    public static int max;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        int[] reDist = new int[N+1];
        max = Integer.MIN_VALUE;
        
        
        ArrayList<Edge>[] list = new ArrayList[N+1];
        ArrayList<Edge>[] reverseList = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to,weight));
            reverseList[to].add(new Edge(from, weight));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reDist, Integer.MAX_VALUE);
        
        dijkstra(list, dist);
        dijkstra(reverseList, reDist);

        for(int i=1;i<N+1;i++){
            max = Math.max(max, dist[i] + reDist[i]);
        }
        
        System.out.println(max);
    }

    public static void dijkstra(ArrayList<Edge>[] list, int[] dist){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.dist, o2.dist));

        queue.add(new Node(X, 0));
        dist[X] = 0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[node.index]) continue;

            for(Edge edge : list[node.index]){
                
                if(dist[node.index] + edge.weight < dist[edge.to]){
                    dist[edge.to] = dist[node.index] + edge.weight;
                    queue.add(new Node(edge.to, dist[edge.to]));
                }
            }
        }
    }
}
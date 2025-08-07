import java.util.*;
import java.lang.*;
import java.io.*;

class boj_13308 {

    static class Node{
        int index;
        long price;
        int minPrice;
        public Node(int index, long price, int minPrice){
            this.index = index;
            this.price = price;
            this.minPrice = minPrice;
        }
    }

    static class Edge{
        int index;
        int weight;
        public Edge(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }
    public static long[][] dist;
    public static int[] cost;
    public static int N;
    public static int M;
    public static ArrayList<Edge>[] list;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        dist = new long[N+1][2501];

        for(long[] arr : dist){
            Arrays.fill(arr, Long.MAX_VALUE);
        }

        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        dijkstra();

        long answer = Long.MAX_VALUE;

        for(int i=0;i<2501;i++){
            answer = Math.min(answer ,dist[N][i]);
        }
        
        System.out.println(answer);
        
    }

    public static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Long.compare(o1.price, o2.price)
        );
        
        queue.add(new Node(1,0,cost[1]));
        dist[1][cost[1]] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.price != dist[node.index][node.minPrice]) continue; 
            
            for(Edge e : list[node.index]){

                long nextCost = e.weight * node.minPrice;
                int min = node.minPrice;
                min = Math.min(cost[e.index], min);

                if(dist[e.index][min] > dist[node.index][node.minPrice] + nextCost){
                    
                    dist[e.index][min] = dist[node.index][node.minPrice] + nextCost;
                    queue.add(new Node(e.index, dist[e.index][min], min));
                }
            }
        }
        
    }
}

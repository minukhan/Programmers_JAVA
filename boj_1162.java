import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1162 {

    static class Node{
        int index;
        long dist;
        int pack;
        public Node(int index, long dist, int pack){
            this.index = index;
            this.dist = dist;
            this.pack = pack;
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
    
    static int N;
    static int M;
    static int K;
    static long[][] dist;
    static ArrayList<Edge>[] list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        dist = new long[N+1][K+1];

        for(long[] arr : dist){
            Arrays.fill(arr, Long.MAX_VALUE);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        dijkstra();

        long min = Long.MAX_VALUE;
        
        for(int i=0;i<K+1;i++){
            min = Math.min(min, dist[N][i]);
        }

        System.out.println(min);
    }

    public static void dijkstra(){

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1.dist != o2.dist) return Long.compare(o1.dist, o2.dist);
                return Integer.compare(o1.pack, o2.pack);
            }
        );
            
        queue.add(new Node(1,0,0));
        dist[1][0] = 0;

            
        while(!queue.isEmpty()){
            
            Node node = queue.poll();
            if(dist[node.index][node.pack] != node.dist) continue;

   
            for(Edge e : list[node.index]){

                // 포장도로를 사용하지 않았을 때
                if(dist[node.index][node.pack] + e.weight < dist[e.index][node.pack]){
                    dist[e.index][node.pack] = dist[node.index][node.pack] + e.weight;
                    
                    queue.add(new Node(e.index,dist[e.index][node.pack],node.pack));
                }
                    
                // 포장도로를 사용할때
                if(node.pack < K && dist[node.index][node.pack] < dist[e.index][node.pack + 1]){
                    dist[e.index][node.pack + 1] = dist[node.index][node.pack];
                    
                    queue.add(new Node(e.index, dist[e.index][node.pack + 1] ,node.pack + 1));
                }
            }
        }
    }
}
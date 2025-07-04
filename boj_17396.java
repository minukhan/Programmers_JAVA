import java.util.*;
import java.lang.*;
import java.io.*;

class boj_17396 {

    public static int N;
    public static int M;
    public static int[] visited;
    public static long[] dist;
    public static ArrayList<Edge>[] list;

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
        long dist;
        public Node(int index, long dist){
            this.index = index;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N];
        dist = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            visited[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dist, Long.MAX_VALUE);

        // 도착지점 0으로 변환
        visited[N-1] = 0;

        list = new ArrayList[N];
        for(int i=0;i<N;i++){
            list[i] = new ArrayList<>();
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

        System.out.println(dist[N-1] == Long.MAX_VALUE ? -1 : dist[N-1]);
        
    }

    public static void dijkstra(){

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> Long.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(0,0));
        dist[0] = 0;

        while(!queue.isEmpty()){

            Node node = queue.poll();
            if(dist[node.index] != node.dist) continue;
            
            for(Edge e : list[node.index]){
                if(dist[e.index] > dist[node.index] + e.weight && visited[e.index] == 0){
                    dist[e.index] = dist[node.index] + e.weight;
                    queue.add(new Node(e.index , dist[e.index]));
                }
            }
        }
        
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class LeastCostFind {

    static class Arrow{
        int arrive;
        int weight;
        public Arrow(int arrive, int weight){
            this.arrive = arrive;
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

    public static int start;
    public static int last;
    public static int[] dist;
    public static ArrayList<Arrow>[] graph;
    public static void LeastCostFind(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 그래프 생성
        graph = new ArrayList[N+1];
        
        // 그래프 초기화
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Arrow>();
        }

        StringTokenizer st;

        // 최단거리들 저장
        dist = new int[N+1];
        for(int i=1;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        // 간선, weight 연결
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Arrow arrow = new Arrow(to,weight);
            graph[from].add(arrow);
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());
        
        dfs();
        
        System.out.println(dist[last]);
    }

    public static void dfs(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)-> o1.dist - o2.dist);

        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] < node.dist) continue;
            
            for(Arrow arrow : graph[node.index]){
                if(dist[node.index] + arrow.weight >= dist[arrow.arrive]) continue;

                dist[arrow.arrive] = dist[node.index] + arrow.weight;
                queue.add(new Node(arrow.arrive,dist[arrow.arrive]));
            }
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


// 6:42

// 종강 마산 버스 집으로가기
// 지도를 보고 짧은길을 찾기
// 마산이 먼저다. 고향으로 가는길에 건우가 있다면 도움을 줄 수 있음.
// 양방향으로 되어있고 출발지는 1번 마산은 V정점
// 건우는 P
// 최단경로가 여러개가 있긴하지만 어떤 경로를 포함하고 오는 방법은 
// 다익스트라를 2번 돌리는 방법밖에없음.

// 가중치는 10,000 이하이므로 양수.
// 정점은 5,000개 간선은 10,000 개이므로 최악의 경우에도 100,000,000 1억이므로 int 가능
// 첫번째 다익스트라를 돌렸을때 V까지 가는 경우와 P 까지 가는 경우를 기록해놓고
// P에서 다익스트라를 돌렸을때 V까지 가는거랑 합쳤을때 같으면 SAVE 아니면 BYE

class boj_18223 {

    static class Node{
        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
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

    public static int N;
    public static int E;
    public static int P;

    public static int[] dist;
    public static ArrayList<Edge>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        
        dijkstra(1);

        int masan = dist[N];
        int kunwoo = dist[P];

        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra(P);
        
        if(masan == kunwoo + dist[N]){
            System.out.println("SAVE HIM");
        }
        else{
            System.out.println("GOOD BYE");
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(start,0));
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[node.index]) continue;
            
            for(Edge edge: list[node.index]){
                int nextIndex = edge.index;
                int nextDist = node.dist + edge.weight;
                
                if(dist[nextIndex] > nextDist){
                    dist[nextIndex] = nextDist;
                    queue.add(new Node(nextIndex, nextDist));
                }
            }
            
        }
    }
}
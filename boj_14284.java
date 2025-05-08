import java.util.*;
import java.lang.*;
import java.io.*;

// 3:37

// 정점 n개 0개의 간선으로 이루어진 무방향 그래프. 양방향

// m개의 가중치 간선의 정보가 있는 간선 리스트가 주어짐.
// 간선 리스트에 있는 간선들을 하나씩 그래프에 추가해나갈 것이다. 
// 특정 정점 s, t 가 연결이 되는 시점에 간선 추가를 멈춤.
// 연결이랑 두 정점이 간선을통해 방문 가능한걸말함.
// 연결이 되는 시점의 간선의 가중치의 합이 최소가 되게하도록 순서 조정.
// 순서를 조정한다는 말은 그냥 최단거리 찾으라는 말?
// n 은 5,000 간선의 갯수는 100,000 까지 가능. 간선들이 쭉 있을때 그냥 최단거리.
// 가중치가 양수이며 100이하. int 가능할듯.
// 그냥 s에서 다익스트라 돌려서 t의 값을 찾으면 답. 


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





























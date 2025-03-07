import java.util.*;
import java.lang.*;
import java.io.*;

class MostFastRoad {

    static class Node{

        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    static class Edge{

        int toNode;
        int distance;
        public Edge(int toNode, int distance){
            this.toNode = toNode;
            this.distance = distance;
        }
    }

    
    public static int[] dist;
    public static ArrayList<Edge>[] graph;
    
    public static void MostFastRoad(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        
        for(int i=1;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=1;i<E+1;i++){
            st= new StringTokenizer(br.readLine());
        
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            
            graph[from].add(new Edge(to,len));
        }

        dijkstra(start);

        for(int i=1;i<N+1;i++){
            int value = dist[i];
            if(value==Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(value);
            }
        }
        
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.dist-o2.dist);

        queue.add(new Node(start,0));
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(dist[node.index] != node.dist) continue;

            for(Edge edge : graph[node.index]){
                if(dist[node.index] + edge.distance < dist[edge.toNode]){
                    queue.add(new Node(edge.toNode,dist[node.index]+ edge.distance));
                    dist[edge.toNode] = dist[node.index] + edge.distance;
                }
            }
        }
        
    }

}

// 간선의 갯수 E
// 정점의 갯수 V

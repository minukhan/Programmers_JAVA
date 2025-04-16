import java.util.*;
import java.lang.*;
import java.io.*;

class boj_11404 { //50분 

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
        int weight;
        public Edge(int toNode,int weight){
            this.toNode = toNode;
            this.weight = weight;
        }
    }
    
    public static int[][] dist;
    public static ArrayList<Edge>[] graph;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n개의 도시 n 은 100
        int n = Integer.parseInt(br.readLine());
        // 버스 ( 도로) m 100,000 개
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i]  = new ArrayList<Edge>();
        }
        dist = new int[n+1][n+1];


        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j){
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }


        for(int i=1;i<n+1;i++){
            dikjstra(i);
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(dist[i][j] == Integer.MAX_VALUE){
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void dikjstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.dist,o2.dist));

        queue.add(new Node(start,0));
        dist[start][start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[start][node.index]) continue;

            for(Edge e : graph[node.index]){
                int toNode = e.toNode;
                int weight = e.weight;

                if(dist[start][toNode] > node.dist + weight){
                    dist[start][toNode] = node.dist + weight;
                    queue.add(new Node(toNode,dist[start][toNode]));
                }
            }
        }
    }
}
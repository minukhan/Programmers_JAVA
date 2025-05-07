import java.util.*;
import java.lang.*;
import java.io.*;

// 1:55
// 방향성이 없는 그래프. -> 양방향 그래프
// 1~N 까지 최단거리로 이동하려한다.
// 2가지 조건이 있다. 임의로 주어진 2개의 정점을 지나야한다는 것. 
// 다시 왔던 간선으로 이동할 수 있음. 두 정점을 거치면서 최단경로로 이동하는 프로그램
// A, B 를 거쳐야하니까 일단 시작점에서 다 돌리기
// 그다음 A에서 돌리기
// 그다음 B애서 돌리기
// 시작 -> A -> B -> 마무리 
// 시작 -> B -> A -> 마무리 
// 이렇게 2가지 경우중 최소값을 찾으면됨.

// 정점 800, 간선 200,000 임
// 리스트로 쭉 받아놓고 만들어놓기


class boj_1504 {

    static class Edge{
        int index;
        int dist;
        public Edge(int index, int dist){
            this.index = index;
            this.dist = dist;
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
    public static int A;
    public static int B;
    public static int[] dist;
    public static ArrayList<Edge>[] list;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to,weight));
            list[to].add(new Edge(from,weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dist = new int[N+1];

        dijkstra(1);
        int one = dist[A];
        int two = dist[B];
        
        dijkstra(A);
        int AtoB = dist[B];
        int AtoN = dist[N];
        
        dijkstra(B);
        int BtoA = dist[A];
        int BtoN = dist[N];

        if(one == Integer.MAX_VALUE || two == Integer.MAX_VALUE || AtoB == Integer.MAX_VALUE || AtoN == Integer.MAX_VALUE || BtoA == Integer.MAX_VALUE || BtoN == Integer.MAX_VALUE){
            System.out.println(-1);
            System.exit(0);
        }
        
        int answer = Math.min(one + AtoB + BtoN , two+ BtoA + AtoN);
        System.out.println(answer);
    }


    public static void dijkstra(int start){

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.dist, o2.dist));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] != node.dist) continue;

            for(Edge e : list[node.index]){
                
                if(dist[e.index] <= dist[node.index] + e.dist ) continue;

                dist[e.index] = dist[node.index] + e.dist;
                queue.add(new Node(e.index , dist[e.index]));
                
            }
        }
    }
}






































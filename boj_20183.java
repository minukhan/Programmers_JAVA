import java.util.*;
import java.lang.*;
import java.io.*;


//9:08

// N개의 교차로와 M개의 골목이 있다. 
// 골목은 길 말하는듯. 
// 양방향으로 이루어져있으며 간선은 하나만 존재한다. 
// 순환하는 방향으로 되어있을듯?
// 모든 골목에 분신을 두고 통행료가있음.
// A -> B 까지 가려하는데 최소한의 비용이 드는 방향으로 가고싶다. 
// 여기서의 조건이 하나 더 붙네 
// 내가 소지한 금액은 정해져있으나 절대치값이 작은 방향으로 가고싶어함.
// 그러나 그런곳은 최대 드는 비용이 내 소지금액보다 클 수 있음.

// 지금 가진 돈으로 못가는 경로면 -1 를 출력
// 일단 다익스트라로 최단거리는 구하는게 맞음.?
// 해봐야 2가지 경우임. 오른쪽으로 도느냐, 왼쪽으로 도느냐. 
// 원래는 최대값으로 채워넣고
// 최소값이니까 채워넣는데. 이제 금액이 넘으면 안됨
// 금액이 넘는 즉시 종료? dist가 기록될꺼니까 그러면 다른 경로가 채워주지않을까
// 총 금액이 넘는거, 안넘는것들중에 절대값이 최소인것들.
// long 을 사용해야함. dist
// 

class boj_20183 {

    public static ArrayList<Edge>[] list;
    public static int N;
    public static int M;
    public static int A;
    public static int B;
    public static long C;
    public static long[] dist;

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
        int abs;
        public Node(int index, long dist, int abs){
            this.index = index;
            this.dist = dist;
            this.abs = abs;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드갯수
        M = Integer.parseInt(st.nextToken()); // 간선갯수
        A = Integer.parseInt(st.nextToken()); // 시작
        B = Integer.parseInt(st.nextToken()); // 도착
        C = Long.parseLong(st.nextToken()); // 돈

        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        dist = new long[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Long.MAX_VALUE;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        System.out.println(dijkstra());
        
        
    }

    public static int dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> {
                if(o1.abs != o2.abs) return Integer.compare(o1.abs, o2.abs);
                return Long.compare(o1.dist, o2.dist);
            }
        );

        queue.add(new Node(A,0,0));
        dist[A] = 0;


        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.index == B){
                return node.abs;
            }

            if(dist[node.index] != node.abs) continue;

            for(Edge edge : list[node.index]){
                int nextIndex = edge.index;
                long newDist = edge.weight + node.dist;
                int newAbs = Math.max(edge.weight, node.abs);

                if(newDist <= C && newAbs < dist[nextIndex]){
                    dist[nextIndex] = newAbs;
                    queue.add(new Node(nextIndex,newDist,newAbs));
                }
            
                    
            }
        }

        return -1;
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

// 9: 04

// 달빛을 바등면 아름다운 구미호로 변신할 수 있다. 
// 늑대도 한마리 살고있음. 

// 1~ N 까지 번호가 붙은 나무가 있고 그 사이에는 M개의 오솔길이 있다. 

// 양방향이고, 중복은 없음. 
// 1번에서 살고있다. 
// 여우는 일정한 속도로 달려가는데 늑대는 여우보다 더 빠르게 달릴 수 있음. 
// 근데 체력이 없어서 다른 전략을 사용한다. 
// 출발할때 두배의 속도로 달려감. 그 뒤로는 오솔길 하나를 절반인 속도로 걸어감. 
// 이거 반복. 
// 여우의 속도를 2로 설정하면 좋을듯. 
// 달빛여우가 먼저 도착할 그루터기에 달빛을 비춰주려고한다. 

// 그냥 다익스트라를 2번 쭉 돌려서 여우, 늑대
// 그 배열을 한번에 쭉 탐색하면 될듯? 

// 오솔길 하나를 두배의 속도로 가는것. 상태를 하나 추가해야할듯. 

// 시간복잡도 
// 노드의 갯수 4000
// 엣지의 갯수 10만개 
// 10 만 * log 4000 약 400만 * 2. 다익스트라 충분할듯. 

class boj_16118 {

    static class Node{
        int index;
        long dist;
        int run;
        public Node(int index, long dist , int run){
            this.index = index;
            this.dist = dist;
            this.run = run;
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
    
    static ArrayList<Edge>[] list;
    static int N;
    static int M;
    static long[][] wolf;
    static long[] fox;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        
        // 0 이면 달리기 차례, 1이면 기어가는 차례
        wolf = new long[2][N+1];
        fox = new long[N+1];
        
        listInit();
        foxInit();
        wolfInit();
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 2로 나중에 나눌때 실수로 가기 싫어서
            int weight = Integer.parseInt(st.nextToken()) * 2; 

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        foxDijkstra();
        wolfDijkstra();

        int answer =0;
        
        for(int i=1;i<N+1;i++){
            long result = Math.min(wolf[0][i], wolf[1][i]);
            
            if( result > fox[i]) answer++;
        }
        
        System.out.println(answer);
        
    }

    public static void wolfDijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Long.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(1, 0 , 0));
        wolf[0][1] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != wolf[node.run][node.index]) continue;

            for(Edge e : list[node.index]){

                long nextDist=0;
                
                if(node.run == 0){
                    nextDist = wolf[node.run][node.index] +  e.weight / 2;
                }
                else{
                    nextDist = wolf[node.run][node.index] +  e.weight * 2;
                }

                int nextRun = node.run == 0 ? 1: 0;
                
                if(wolf[nextRun][e.index] > nextDist){
                    wolf[nextRun][e.index] = nextDist;
                    queue.add(new Node(e.index, wolf[nextRun][e.index], nextRun));
                }
            }
        }
    }

    public static void foxDijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Long.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(1, 0, 0));
        fox[1] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != fox[node.index]) continue;

            for(Edge e : list[node.index]){

                if(fox[e.index] > fox[node.index] + e.weight){
                    fox[e.index] = fox[node.index] + e.weight;
                    queue.add(new Node(e.index, fox[e.index] , 0));
                }
            }
        }
    }





    static void listInit(){
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
    }
    
    static void foxInit(){
        Arrays.fill(fox , Long.MAX_VALUE);
    }
    
    static void wolfInit(){
        for(int i=0;i<2;i++){
            Arrays.fill(wolf[i] , Long.MAX_VALUE);
        }
    }
}

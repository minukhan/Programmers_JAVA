import java.util.*;
import java.lang.*;
import java.io.*;


// 5:01

// 주식회사 승범이네 본사가 있음
// 직원을 해고하고 다시 뽑으려함.
// 면접자들은 서로다른 N개의 도시에 거주하고있음.
// N개의 도시중에 K개의 도시에 면접장을 배치함. K개는 면접장이 바로 있는것.
// 단방향 그래프임. 없을수도 여러개있을 수 있고
// 적어도 하나의 면접장까지 갈 수 있는 경로가 반드시 존재.
// 모든 면접자는 본인의 도시에서 출발해서 가장 가까운 면접장으로 찾아갈 예정.
// 면접장까지의 거리가 가장 먼 도시와 그 거리를 구해라.
// 음. 일단 K번 다익스트라 돌리고 그것들을 비교해보면 쉽게 알 수 있으나
// K가 100,000 개까지 가능하므로 안될 것 같고
// N 은 100,000
// M 은 500,000
// K 는 100,000
// C 는 가중치 100,000 까지 가능하다. 

// 그럼 최악일경우 100,000 * 100,000 이므로  long 을 사용해야함 거리 누적할때
// 어떻게 최단거리를 다 구할까? 일단 가중치가 양수이므로 다익스트라를 사용할 수 있음. 
// 그러나 이걸 어떻게 사용하느냐. K번 돌리면 당연히 시간초과고. 
// 단방향그래프. 일단 K부터 시작한다고 쳤을때. 
// 그래프의 방향을 역으로하고 

// 1 2 3 4 5
//  5 6 7 8 9
// 3 * 78 * 0
// K 들과의 관계가 중요할 듯 해보이는데. 
// 다 떄려넣고 다익스트라 돌리면 되는거같은데..

// 그니까 다익스트라 문제는 배열을 기억해두기. 역으로 바꿔서 가기. 그리고 이렇게

// 초기값이 여러개일때 유형이 있는듯.

class boj_17835 {

    public static int N;
    public static int M;
    public static int K;
    public static ArrayList<Node> initList;
    public static ArrayList<Edge>[] list;
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
        public Node(int index, long dist){
            this.index = index;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

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

            list[to].add(new Edge(from, weight));
        }
        initList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<K;i++){
            initList.add(new Node(Integer.parseInt(st.nextToken()), 0));
        }

        dijkstra();

        findAnswer();
        
    }

    public static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Long.compare(o1.dist,o2.dist)
        );

        for(Node node : initList){
            queue.add(node);
            dist[node.index] = 0;
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] != node.dist) continue;
            
            for(Edge edge : list[node.index]){

                if(dist[edge.index] > dist[node.index] + edge.weight){
                    dist[edge.index] = dist[node.index] + edge.weight;
                    queue.add(new Node(edge.index, dist[edge.index]));
                }
            }
        }
        
    }

    public static void findAnswer(){
        long max = Long.MIN_VALUE;
        int index = 0;

        for(int i=0;i<dist.length;i++){
            if(dist[i] == Long.MAX_VALUE) continue;

            if(max < dist[i]){
                index = i;
                max = dist[i];
            }
        }

        System.out.println(index);
        System.out.println(max);
    }
}
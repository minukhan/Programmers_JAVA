import java.util.*;
import java.lang.*;
import java.io.*;


// 11 : 24

// N 개의 노드로 이루어진 트리가 주어진다. 
// M 개의 두 노드 쌍을 입력받을 떄 두 노드 사이의 거리를 출력해라. 
// 첫째줄에 노의갯수 N 과 거리를 알고싶은 노드 쌍으 ㅣ갯수 M 이 입력되고 
// 다음 N-1 개의 줄에 트리상에 연결된 두 점과 거리를 입력받는다?
// 그래프?
// 트리인데 길이가 있는것?
// 1과 2의 거리를 알고싶다?

// N 은 1000개 있고, M은 1000 개 있음. 
// N번을 최악으로 돌아서 M 번 돌아도 100만.
// 두 점의 거리는 1만.
// 최악으로 돌아도 1억. 
// 양방향으로 돌면 되는건가? 찾기만하면되자나. 값 기록하고. 

class boj_1240 {

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
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static int[] visited;
    public static ArrayList<Edge>[] list;
    public static int M;
    public static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        visited = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            init();
            int result = bfs(start, end);

            System.out.println(result);
        }
        
    }

    public static void init(){
        for(int i=0;i<N+1;i++){
            visited[i] = 0;
        }
    }

    public static int bfs(int start, int end){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();


            if(node.index == end){
                return node.value;
            }
            for(Edge e : list[node.index]){

                if(visited[e.index] == 1) continue;

                visited[e.index] = 1;
                queue.add(new Node(e.index, node.value + e.weight));
            }
        }

        return -1;
    }
}












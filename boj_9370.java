import java.util.*;
import java.lang.*;
import java.io.*;


class boj_9370 {

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
    public static int N;
    public static int M;
    public static int t;
    public static int s;
    public static int g;
    public static int h;
    public static ArrayList<Edge>[] list;
    public static int[] dist;
    public static int[] destination;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(T > 0){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            for(int i=0;i<N+1;i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list[from].add(new Edge(to, weight));
                list[to].add(new Edge(from, weight));
            }

            dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            destination = new int[t];
            for(int i=0;i<t;i++){
                destination[i] = Integer.parseInt(br.readLine());
            }

            int[] g_end = new int[t];
            int[] h_end = new int[t];
            int[] lastCheck = new int[N+1];
            
            dijkstra(s);
            for(int i=0;i<N+1;i++){
                lastCheck[i] = dist[i];
            }
            int start_h = dist[h];
            int start_g = dist[g];
            
            init();
            
            dijkstra(g);
            int g_h = dist[h];
            for(int i=0;i<t;i++){
                g_end[i] = dist[destination[i]];
            }
            
            init();

            dijkstra(h);
            int h_g = dist[g];
            for(int i=0;i<t;i++){
                h_end[i] = dist[destination[i]];
            }

            ArrayList<Integer> answer = new ArrayList<>();
            
            for(int i=0;i<t;i++){
                int first = 1000000;
                int second = 1000000;
                boolean check = false;
                // 시작 -> h -> g -> end
                first = start_h + h_g + g_end[i];
                if(lastCheck[destination[i]] == first) answer.add(destination[i]);
                // 시작 -> g -> h -> end
                second = start_g + g_h + h_end[i];
                if(lastCheck[destination[i]] == second) answer.add(destination[i]);
            }

            answer.sort(Comparator.naturalOrder());
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<answer.size();i++){
                sb.append(answer.get(i)).append(" ");
            }
            
            System.out.println(sb.toString());
            
            T--;
        }

    }

    public static void init(){
        Arrays.fill(dist, Integer.MAX_VALUE);
    }
    public static void dijkstra(int start){

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] != node.dist) continue;

            for(Edge e : list[node.index]){
                int nextIndex = e.index;
                int currentDist = e.weight + node.dist;
                int prevDist = dist[nextIndex];

                if(currentDist < prevDist){
                    dist[nextIndex] = currentDist;
                    queue.add(new Node(nextIndex, currentDist));
                }
            }
        }
    }
}
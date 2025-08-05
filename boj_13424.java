
import java.util.*;
import java.lang.*;
import java.io.*;

// 3: 28
// 가짜 갈레온에 모임의 장소를 적으면 가짜 갈레온에 해리가 적은 장소가 나타난다.
// 모임에 사용할 방이 N 개있다. 
// 중복된 번호는 없음. M개의 비밀통로로 연결되어있다. -> 그래프
// 양방향 통행이 가능하며 자연수의 길이를 가진다. -> 다익스트라? 
// 모임에 참여하는 친구들은 총 K 명이다. 
// 친구들은 방 하나에 한명씩 있었고 비밀통로로 이동해서 모임장소로 가려한다. 
// 가장 짧은 경로만을 사용한다. 친구들의 이동거리의 총합이 최소가 되는 방을 사용하기로 함.
// 방의 갯수는 100 다익스트라의 시간복잡도는 V + E log V 니까 100 + 5000 이니까 시간은 널널함. 
// .C는 1000이므로 1000 * 100 해도 int 가능. 
// 모든 방을 다익스트라 돌려도 되는게 100 * 5100 * 20정도라고 하면 
// 20000 * 100 = 200만이므로 충분히 가능. 

class boj_13424 {
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
    public static int[] dist;
    public static int N;
    public static int M;
    public static ArrayList<Edge>[] list;
    public static ArrayList<Integer> friend;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
    
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
    
            list = new ArrayList[N+1];
            for(int i=1;i<N+1;i++){
                list[i] = new ArrayList<>();
            }
    
            dist = new int[N+1];
            
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
    
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
    
                list[from].add(new Edge(to, weight));
                list[to].add(new Edge(from, weight));
            }
            int K = Integer.parseInt(br.readLine());
    
            friend = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<K;i++){
                friend.add(Integer.parseInt(st.nextToken()));    
            }
    
            int answer = Integer.MAX_VALUE;
            int index=0;
            for(int i=1;i<N+1;i++){
                for(int j=0;j<N+1;j++){
                    dist[j] = Integer.MAX_VALUE;
                }
                dijkstra(i);
                int result = count();
                if(answer > result){
                    answer = result;
                    index = i;
                }
            }
    
            System.out.println(index);
        }
        
    }

    public static void dijkstra(int start){

        int min = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.dist, o2.dist)
        );

        queue.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.dist != dist[node.index]) continue;

            for(Edge e : list[node.index]){
                if(dist[e.index] > dist[node.index] + e.weight){
                    dist[e.index] = dist[node.index] + e.weight;
                    queue.add(new Node(e.index, dist[e.index]));
                }
            }
        }
    }
    
    public static int count(){
        int sum =0;
        
        for(int value : friend ){
            sum += dist[value];     
        }

        return sum;
    }
}





























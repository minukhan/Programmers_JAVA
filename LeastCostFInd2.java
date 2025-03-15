import java.util.*;
import java.lang.*;
import java.io.*;

class LeastCostFInd2 { // 11:55

    public static int N;
    public static int M;
    public static int start;
    public static int end;
    public static int[] dist;
    public static int[] trace;
    public static ArrayList<Bus>[] graph;

    static class Node{
        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    static class Bus{
        int to;
        int cost;
        public Bus(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void LeastCostFInd2(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Bus>();
        }

        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[from].add(new Bus(to, cost));
        }
        
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        trace = new int[N+1];

        Arrays.fill(trace,-1);

        for(int i=1;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstra();
        int traceCity = end;
        Stack<Integer> stack = new Stack<>();
        
        while(traceCity != -1){
            stack.push(traceCity);
            traceCity = trace[traceCity];
        }

        int count = stack.size();

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            int number = stack.pop();
            sb.append(number).append(" ");
        }

            
        System.out.println(dist[end]);
        System.out.println(count);
        System.out.println(sb.toString());
    
    }

    public static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        queue.add(new Node(start,0));
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            Node city = queue.poll();

            int cityIndex = city.index;
            int currentDist = city.dist;

            if(currentDist != dist[cityIndex]) continue;
            
            for(Bus bus : graph[cityIndex]){
                int nextIndex = bus.to;
                int nextCost = bus.cost;

                if(dist[nextIndex] <= currentDist + nextCost) continue;

                trace[nextIndex] = cityIndex;
                dist[nextIndex] = currentDist + nextCost;
                queue.add(new Node(nextIndex,dist[nextIndex]));
            }
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


class boj_9205 {

    static class Node{
        int y;
        int x;
        int index;
        public Node(int y, int x, int index){
            this.y = y;
            this.x = x;
            this.index = index;
        }
    }

    public static int N;
    public static Node start;
    public static Node end;
    public static ArrayList<Node> list;
    public static ArrayList<Node> nextList;
    public static int[] visited;
    public static Queue<Node> queue;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T > 0){

            N = Integer.parseInt(br.readLine());
            st  = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), -1);

            list = new ArrayList<>();
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), i ));
            }
            visited = new int[N+1];
            
            st  = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), N);
            list.add(end);
            
            bfs();

            T--;
            
        }

        
    }

    public static void bfs(){

        queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == end.x && node.y == end.y){
                System.out.println("happy");
                return;
            }
            // 방문하지 않았고, 방문할 수 있는 리스트들 뽑아내기.
            check(node);
        }

        System.out.println("sad");
    }

    public static void check(Node node){

        int x = node.x;
        int y = node.y;

        for(int i=0;i<N+1;i++){

            
            Node findNode = list.get(i);

            
            int nx = findNode.x;
            int ny = findNode.y;

            if(visited[findNode.index] == 1) continue;
            
            int result = Math.abs(nx - x) + Math.abs(ny - y);
            
            if(result <= 1000){
                queue.add(findNode);
                visited[findNode.index] = 1;
            }
        }
    }
}
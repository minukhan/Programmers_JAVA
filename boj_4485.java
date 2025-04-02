import java.util.*;
import java.lang.*;
import java.io.*;

class boj_4485 {

    public static int dist[][];
    public static int answer[][];
    public static int[] dx  = {1,-1,0,0};
    public static int[] dy  = {0,0,1,-1};
    public static int N;

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count=1;
        while(true){
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            
            if(N == 0) break;

            dist = new int[N][N];
            answer = new int[N][N];

            for(int[] value : answer){
                Arrays.fill(value,Integer.MAX_VALUE);
            }

            for(int i=0;i<N;i++){
                
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    dist[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            System.out.println("Problem " + count + ": " + answer[N-1][N-1]);
            
            count++;

        }
        
    }

    public static void dijkstra(){

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.distNode - o2.distNode);

        queue.add(new Node(0,0,dist[0][0]));
        answer[0][0] = dist[0][0];
        
        while(!queue.isEmpty()){

            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            if(answer[y][x] != node.distNode) continue;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                int distance = node.distNode + dist[ny][nx];

                if(answer[ny][nx] <= distance) continue;

                queue.add(new Node(nx,ny,distance));
                answer[ny][nx] = distance;
            }
        }
    }

    static class Node{
        int x;
        int y;
        int distNode;
        
        public Node(int x, int y, int distNode){
            this.x= x;
            this.y= y;
            this.distNode = distNode;
        }
    }

}
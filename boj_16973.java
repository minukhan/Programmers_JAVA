import java.util.*;
import java.lang.*;
import java.io.*;

class boj_16973 {

    public static int N;
    public static int M;
    public static int[][] road;
    public static int[][] visited;
    public static int H;
    public static int W;
    public static int startY;
    public static int startX;
    public static int endY;
    public static int endX;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    static class Node{
        int y;
        int x;
        int count;
        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(road[i][j] == 1){
                    init(i,j);
                }
            }
        }

        bfs();
    }

    public static void init(int y, int x){ // 2, 4

        int sy = y - H + 1;
        int sx = x - W + 1;
        if(sy < 1) sy = 1;
        if(sx < 1) sx = 1;

        for(int i=sy;i<=y;i++){
            for(int j=sx;j<=x;j++){
                visited[i][j] = 1;
            }
        }
    }


    public static void bfs(){
        
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startY, startX,0));
        visited[startY][startX] = 1;

        
        while(!queue.isEmpty()){

            Node node = queue.poll();

            if(node.y == endY && node.x == endX){
                System.out.println(node.count);
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(ny < 1 || ny + H - 1 > N || nx < 1 || nx + W - 1 > M) continue;
                if(visited[ny][nx] == 1) continue;
                if(road[ny][nx] == 1) continue;

                
                queue.add(new Node(ny,nx,node.count + 1));
                visited[ny][nx] = 1;
            }
        }

        System.out.println(-1);
    }
}
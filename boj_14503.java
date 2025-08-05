
import java.util.*;
import java.lang.*;
import java.io.*;



class boj_14503 {
    
    public static int N;
    public static int M;
    public static int[][] road;
    public static int[][] visited;

    static class Node{
        int y;
        int x;
        int direct;
        public Node(int y, int x, int direct){
            this.y = y;
            this.x = x;
            this.direct = direct;
        }
    }
    public static int Y;
    public static int X;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    public static int answer=0;
    public static int direction;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        
        road = new int[N][M];
        visited = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        
        System.out.println(answer);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(Y,X,direction));
        answer++;
        visited[Y][X] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            boolean check = true;
            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                
                if(ny < 0 || ny >= N || nx < 0 || nx >=M) continue;
                if(visited[ny][nx] == 1) continue;
                if(road[ny][nx] == 1) continue;

                check = false;
            }
            
            int currentDirection = node.direct;
            
            if(!check){
                // 반시계 회전. 0 북 1 서 2 남 3 동 으로하면 접근할때 +1 만 해주면됨. 
                // 전진.
                while(true){
                    currentDirection = (currentDirection + 3) % 4;
                    
                    int nx = node.x + dx[currentDirection];
                    int ny = node.y + dy[currentDirection];

                    if(ny < 0 || ny >= N || nx <0 || nx >=M) continue;
                    if(visited[ny][nx] == 1) continue;
                    if(road[ny][nx] == 1) continue;

                    queue.add(new Node(ny,nx, currentDirection));
                    visited[ny][nx] = 1;
                    answer++;
                    break;
                }
            }
            else{
                // 후진로직
                int index = (node.direct + 2) % 4;
                int nx = node.x + dx[index];
                int ny = node.y + dy[index];

                if(ny < 0 || ny >= N || nx <0 || nx >=M) return;
                if(road[ny][nx] == 1) return;
                
                queue.add(new Node(ny,nx, node.direct));
            }
        }
    }
}
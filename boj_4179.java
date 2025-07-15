
import java.util.*;
import java.lang.*;
import java.io.*;


class boj_4179 {

    static class Node{
        int y;
        int x;
        int fire;
        int count;
        public Node(int y, int x, int fire, int count){
            this.x = x;
            this.y = y;
            this.fire = fire;
            this.count = count;
        }
    }

    public static Node start;
    public static Queue<Node> queue;
    public static int road[][];
    public static int visited[][];

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int N;
    public static int M;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        road = new int[N+2][M+2]; // 1이면 벽, 0 이면 갈 수 있는 곳. 
        visited = new int[N+2][M+2]; // 0이면 갈 수 있는 상태, 1이면 못가는 상태
        
        queue = new LinkedList<>();
        int startX = 0;
        int startY = 0;
        
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            String input  = st.nextToken();
            for(int j=1;j<M+1;j++){
                
                if(input.charAt(j-1) == 'J'){
                    startX = j;
                    startY = i;
                }
                if(input.charAt(j-1) == 'F'){
                    // queue 에다가 넣어야할듯.
                    queue.add(new Node(i,j,1,0));
                    visited[i][j] = 1;
                }
                if(input.charAt(j-1) == '#'){
                    road[i][j] = 1;
                }
            }
        }

        start = new Node(startY,startX, 0,0);
        queue.add(start);
        visited[startY][startX] = 1;

        bfs();
        
    }

    public static void bfs(){

        // 초기값 넣었고
        // 선언까지 했음.

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.y == N+1 || node.y == 0 || node.x == M+1 || node.x == 0){
                // 범위 밖으로 나왔는데 불이 아닌경우 출력
                if(node.fire ==0){
                    System.out.println(node.count);
                    return;
                } 
                else{ // 불인경우 그냥 종료
                    continue;
                }
            }
            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                    
                if(ny < 0 || ny >= N+2 || nx < 0 || nx >= M+2) continue;
                if(visited[ny][nx] == 1) continue;
                if(road[ny][nx] == 1) continue;

                queue.add(new Node(ny,nx,node.fire, node.count + 1));
                visited[ny][nx] = 1;
            }
        }

        System.out.println("IMPOSSIBLE");
        
    }
}

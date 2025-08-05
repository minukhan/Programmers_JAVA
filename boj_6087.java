import java.util.*;
import java.lang.*;
import java.io.*;


// 1:45

// 크기가 정사각형으로 나누어진 W, H 크기의 지도가 있다.
// 벽이거나 빈칸. 그리고 c 로 되어있다. 
// 두칸을 레이저로 통신하기위해서 설치해야하는 거울의 갯수의 최솟값.
// 레이저는 c에서만 발사할 수 있고 거울을 설치해서 90도 회전을 시킬 수 있다.
// 시간복잡도

// 100 까지 가능. 
// BFS 는 가능할듯. 
// 어떻게 돌릴건지가 문제인듯.

// 이전방향을 기억해놨다가. 그 방향으로 이동할때는 카운트를 하지 않는다. 
// 만약 턴을 한다면 거울을 설치한 것. 

// 시작점을 골라야함. 

class boj_6087 {

    static class Node{
        int y;
        int x;
        int count;
        int direction;
        public Node(int y, int x, int count, int direction){
            this.y =y;
            this.x = x;
            this.count = count;
            this.direction = direction;
        }
    }

    public static Node start;
    public static Node end;
    public static int[] dx = {0,0, -1, 1};
    public static int[] dy = {1,-1, 0, 0};
    public static int[][][] visited;
    public static int[][][] dist;
    public static int min = Integer.MAX_VALUE;
    public static int[][] road;
    public static int M;
    public static int N;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
        boolean first = true;

        road = new int[N][M];
        visited = new int[4][N][M];
        dist = new int[4][N][M];
        
        
        // 벽 : 1 , 빈칸 : 0 ,
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                
                char check = input.charAt(j);
                if(check == 'C'){
                    if(first){
                        start = new Node(i,j,0,0); 
                        first = false;
                    }
                    else{
                        end = new Node(i,j,0,0);
                    }
                    continue;
                }

                if(check == '*') road[i][j] = 1;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                for(int k=0;k<M;k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        bfs();

        for(int i=0;i<4;i++){
            min = Math.min(min, visited[i][end.y][end.x]);
        }

        System.out.println(min);
        
        
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        // 모든 방향 큐에 추가. 및 방문처리. 
        for(int i=0;i<4;i++){
            queue.add(new Node(start.y, start.x, 0, i));
            visited[i][start.y][start.x] = 0;
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 방향이 같으면 카운트 하지 않음.
                // 방향이 다르면 카운트해야함.

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(road[ny][nx] == 1) continue;
                int newCount = node.count + (node.direction == i ? 0 : 1);
                if(visited[i][ny][nx] <= newCount) continue;
                
                queue.add(new Node(ny,nx,newCount, i));
                visited[i][ny][nx] = newCount;
            }
        }
            
    }
}

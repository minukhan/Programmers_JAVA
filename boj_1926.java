import java.util.*;
import java.lang.*;
import java.io.*;

// 4:21
// 도화지 그림중 가장 넓은것의 넓이를 출력해라
// 1로 연결되어있으면 그림이라고 정의된 것. 가로나 세로로 연결된것은 연결
// 상하좌우는 연결 세로크기 n 가로크기 m 이 주어지고 그림의 정보가 주어짐
// 완탐으로 가기에는 2의 250,000 승이므로 안되고
// BFS 로 가는게 좋을듯. 상하좌우 해주고 1이면 큐에넣기
// for문으로 다 돌아보고 bfs 돌린다음 max 값 출력해주면 될듯. 방문한곳은 0으로 바꾸기

class boj_1926 {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int count=0;
    public static int Ncount=0;
    public static int max=0;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1){
                    count++;
                    Ncount=0;
                    bfs(j,i);

                    max = Math.max(max, Ncount);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        map[y][x] =0;
        Ncount++;
            
        while(!queue.isEmpty()){
            int prevX =queue.poll();
            int prevY = queue.poll();

            for(int i=0;i<4;i++){
                int nx = prevX + dx[i];
                int ny = prevY + dy[i];


                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] == 0) continue;

                map[ny][nx] =0;
                queue.add(nx);
                queue.add(ny);
                Ncount++;
            }
        }
    }
}

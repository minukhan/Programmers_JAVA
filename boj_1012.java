import java.util.*;
import java.lang.*;
import java.io.*;


// 5:30

// 해충방지에 효과적인 배추흰지렁이 구입.
// 이 지렁이는 배추 근처에 서식하며 해충을 잡아먹음
// 어떤 배추에 살고있으면 인접한 다른 배추로 이동할 수 있어서 해충으로부터 보호할 수 있음. 
// 배추를 군데군데 심어놓음. 지렁이가 그냥 연결되어있으면 다 관리해준다고 보면됨.
// 그니까 구역 나눠둔게 몇개냐 이거임 bfs 단순한문제

class boj_1012 {

    public static int N;
    public static int K;
    public static int M;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int count=0;
    public static int[][] road;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T > 0){
            count =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
    
            road = new int[N][M];
    
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
    
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
    
                road[y][x] = 1;
            }
    
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(road[i][j] == 1){
                        count++;
                        bfs(j,i);
                    }
                }
            }
    
            System.out.println(count);
            T--;
        }
    }

    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        road[y][x] = 0;

        while(!queue.isEmpty()){
            int prevX = queue.poll();
            int prevY = queue.poll();

            for(int i=0;i<4;i++){
                int nx = prevX + dx[i];
                int ny = prevY + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(road[ny][nx] == 0) continue;

                queue.add(nx);
                queue.add(ny);
                road[ny][nx] = 0;
            }
        }
    }

}
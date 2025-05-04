import java.util.*;
import java.lang.*;
import java.io.*;


// 1:48
// 빙산의 높이가 주어지고 바다는 0
// 1년마다 주위에 바다가 있는 갯수만큼 높이가 준다.
// 0보다는 더 줄어든진 않는다.
// 일단 문제에서 덩어리, 최초시간이 나온걸 보니 BFS 로 돌리는게 맞다.
// 이때 2덩어리 이상으로 분리되는 최초의 시간을 구해라.
// N과 M은 3이상 300이하.
// 10까지 들어갈 수 있으며 
// 체크를 하는걸 어떻게 해야할까? BFS로 돈다..? 매 초마다 돌아야하나? 
// 시간초과 날것같은데 흠..
// 0이아닌곳을 시작점으로 시작. 이때 0의 갯수를 count 그것만큼 줄이는 배열을 기록
// 그리고 0이면 continue 0이 아니면 queue 에 추가. 그렇게 쭉 가고 2중for문으로 돌텐데
// size를 체크 이때 1이면 다시 반복.

class boj_2573 {

    public static int N;
    public static int M;
    public static int[][] visited;
    public static int[][] map;
    public static int[][] nextMap;
    public static int[] dx ={0,0,-1,1};
    public static int[] dy ={-1,1,0,0};

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        nextMap = new int[N][M];
        visited = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                nextMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        int count =0;
        boolean check = true;
        
        while(true){
            answer++;
            count =0;
            check = false;
            
            for(int[] row : visited){
                Arrays.fill(row, 0);
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map[i][j] = nextMap[i][j];
                }
            }
            
            for(int[] row : nextMap){
                Arrays.fill(row, 0);
            }

            for(int i=1;i<N;i++){
                for(int j=1;j<M;j++){
                    if(visited[i][j] != 1 && map[i][j] != 0){
                        bfs(j,i);
                        count++;
                        check = true;
                    }
                }
            }

            if (count >= 2) {
                System.out.println(answer-1);
                return;
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }
        }
        
    }

    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        visited[y][x] = 1;

        while(!queue.isEmpty()){
            int sea =0;
            int prevX = queue.poll();
            int prevY = queue.poll();
            
            for(int i=0;i<4;i++){
                int nx = prevX + dx[i]; 
                int ny = prevY + dy[i]; 

                if(nx < 0 || nx >=M || ny < 0 || ny >=N) continue;

                if(map[ny][nx] == 0){
                    sea++;
                    continue;
                }
                if(visited[ny][nx] == 1) continue;

                queue.add(nx);
                queue.add(ny);
                visited[ny][nx] = 1;
            }

            nextMap[prevY][prevX] = Math.max(0,map[prevY][prevX] - sea);
        }
        
    }
}
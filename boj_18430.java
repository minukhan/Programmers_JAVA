import java.util.*;
import java.lang.*;
import java.io.*;

class boj_18430 { // 4:16

    // 부메랑 무기를 개발하는 공학자
    // 고급나무재료를 구함 이 나무는 N * M 크기의 직사각형 형태
    // 나무의 재료의 부위마다 그 강도가 조금씩 다르다. 
    // 자라서 여러개의 부메랑을 만드려한다. 이때 부메랑은 항생 3칸을 차지하는 ㄱ 모양으로
    // 중심이 되는 칸은 2배로 받음. 
    // 가운데는 강도가 2배이니까 가장 큰값을 넣으면 좋겠네 근데 다 탐색해봐야함.
    // 이때 N,M 이 가로 세로인데 5까지이고 강도를 나타내는 숫자는 100을 넘어가지 않는다.
    // 일단 먼저 쪼개야하는데. 어떻게 쪼갤까.
    // 격자를 다 돌면서 중심을 두고 4가지 경우에 대해서 for 문을 돈다. 
    // 부메랑이 없을 경우에는 0을 출력한다.

    public static int N;
    public static int M;
    public static int max;
    public static int[][] road;
    public static int[][] visited;
    public static int[][] dx = {{0,-1,0} , {0,-1,0} , {0,0,1} , {0,0,1}};
    public static int[][] dy = {{0,0,-1} , {0,0,1} , {0,1,0} , {0,-1,0}};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        road = new int[N][M];
        visited = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        
        System.out.println(max);
    }


    public static void dfs(int x, int y, int sum){

        if(y == N){
            max = Math.max(max, sum);
            return;
        }

        int nx = x+1;
        int ny = y;
        if(nx == M){
            nx = 0;
            ny = y+1;
        }

        if(visited[y][x] == 1){
            dfs(nx,ny,sum);
            return;
        }

        for(int d=0;d<4;d++){
            int ax = x + dx[d][1];
            int ay = y + dy[d][1];
            int bx = x + dx[d][2];
            int by = y + dy[d][2];

            if(ax < 0 || ax >= M || ay < 0 || ay >=N) continue;
            if(bx < 0 || bx >= M || by < 0 || by >=N) continue;
            if(visited[ay][ax] == 1 || visited[by][bx] == 1) continue;

            visited[ay][ax] = 1;
            visited[by][bx] = 1;
            visited[y][x] = 1;

            int value = road[y][x] * 2 + road[ay][ax] + road[by][bx];

            dfs(nx,ny,sum + value);
            visited[ay][ax] = 0;
            visited[by][bx] = 0;
            visited[y][x] = 0;
        }
        dfs(nx, ny, sum);
    }
}
// 일단 패착은 for문을 안에다 넣어야하는지 밖에다 넣어야하는지 판단이 안섬.
// 2중for문 + dfs 는 매우 비효율적이므로 이럴떄는 nextX, nextY 방법을 떠올려보자.
// 그걸 이용해서 순서대로 탐색을 진행하다보면 중복되는 dfs도없고 깔끔해짐.
// 그리고 가짓수가 얼마 안되면 3개처럼 그냥 코드로 구현하자 for문 사용하지말고 사용하니까
// 생각보다 복잡해짐.

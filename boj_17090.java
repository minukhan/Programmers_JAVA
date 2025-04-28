import java.util.*;
import java.lang.*;
import java.io.*;


// 2: 28
// 크기가 N * M 인 미로가 있다. 이 미로는 1*1 칸으로 나누어져있고 
// 각 미로의 칸에는 문자가 있는데 그 문자에 따라서 다른칸으로 이동할 수 있음.
// URDL 상호좌우로 이동할 수있고 미로에서 탈출 가능한 칸의 갯수를 계산
// 이떄 적힌대로 이동했을때 경계 밖으로 나가면 탈출했다함
// 모든 칸을 계산해봤을때 탈출되는 칸의 갯수를 구해라.
// N 은 500, M 은 500임.
// 최대 250,000 이므로 nlogn 까지는 가능. 
// 다 탐색해보려하면 최악 250,000 * 250,000 이므로 당연히 안됨.
// 근데 생각해보면 하나선택해서 돌때 그 돈 위치들을 기억해뒀다가 못나가면 다 false떄리면
// 될듯? 접근 자체는 쉽네 순환하는 경우도 있으니 기록해놨다가 그곳을 방문한 곳이면 다 false
class boj_17090 {

    public static int N;
    public static int M;
    public static int max;
    public static int answer=0;
    public static char[][] miro;
    public static int[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static HashSet<Integer> set;
    
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        visited = new int[N][M];
        max = Math.max(N,M);
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String dis = st.nextToken();
            for(int j=0;j<M;j++){
                miro[i][j] = dis.charAt(j);
            }
        }

        set = new HashSet<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j] == 0){
                    set.add(j * (max+1) + i);
                    dfs(j,i);
                }
            }
        }
        
        System.out.println(answer);
    }
    public static void dfs(int x, int y){

        int direct = direction(x,y);

        int nx = x + dx[direct];
        int ny = y + dy[direct];

       // 밖으로 벗어날경우
        // 리스트에 넣어놨던 것들 모두 visited 처리하고 count 세고 다음진행
        if(nx < 0 || nx >= M || ny < 0 || ny >=N || visited[ny][nx] == 1){
            for(int value : set){
                int vy = value % (max+1);
                int vx = value / (max+1);
                visited[vy][vx] = 1;
                answer++;
            }

            set.clear();
            return;
        }

        // 아닐경우
        // 리스트에 포함되어있는경우 판단하고 포함되어있다면 리스트 모두 visited 
        if(set.contains(nx*(max+1) + ny) || visited[ny][nx] == -1){
            for(int value : set){
                int vy = value % (max+1);
                int vx = value / (max+1);
                visited[vy][vx] = -1;
            }
            set.clear();
            return;
        }
        
        
        // 안되어있는경우 계속진행.

        if(visited[ny][nx] == 0){
            set.add(nx * (max+1) + y);
            dfs(nx , ny);
        }
    }

    public static int direction(int x, int y){
        char direct = miro[y][x];
        switch(direct){
            case 'D':
                return 0;
            case 'U':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }
        return -1;
    }
}
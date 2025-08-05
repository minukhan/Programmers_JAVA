import java.util.*;
import java.lang.*;
import java.io.*;


class boj_1520 {
    public static int[][] road;
    public static int[][] visited;
    public static int[][] dp;
    public static int N;
    public static int M;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};

    static class Node{
        int x;
        int y;
        public Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    public static int count=0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[N][M];
        visited = new int[N][M];
        dp = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        visited[0][0] = 1;
        int count = dfs(new Node(0,0));

        System.out.println(count);
    }
    public static int dfs(Node node){
        int y = node.y;
        int x = node.x;

        if(node.y == N-1 && node.x == M-1){
            return 1;
        }
        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        
        for(int i=0;i<4;i++){

            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if(visited[ny][nx] == 1) continue;
            if(road[node.y][node.x] <= road[ny][nx]) continue;

            visited[ny][nx] = 1;
            dp[y][x] += dfs(new Node(ny,nx));
            visited[ny][nx] = 0;
        }

        return dp[y][x];
        
    }
}












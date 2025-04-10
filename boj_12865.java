import java.util.*;
import java.lang.*;
import java.io.*;

class boj_12865 {
    // 2:44
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j=1;j<=K;j++){
                if(W <= j){
                   dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}
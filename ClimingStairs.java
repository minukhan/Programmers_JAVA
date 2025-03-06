import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class ClimingStairs {
    public static void ClimingStairs(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] score = new int[N+1];
        for(int i=1;i<N+1;i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] dp = new int[N+1][2];

        dp[1][0] = 0;
        dp[1][1] = score[1];

        if(N>=2){
            dp[2][0] = score[2]; 
            dp[2][1] = score[1] + score[2];
        }
        

        // 점화식을 토대로 dp 배열 채우기
        for (int i = 3; i <= N; i++){
            dp[i][0] = Math.max(dp[i - 2][0] + score[i], dp[i - 2][1] + score[i]);
            dp[i][1] = dp[i - 1][0] + score[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    
    }
}
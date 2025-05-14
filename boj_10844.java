import java.util.*;
import java.lang.*;
import java.io.*;



class boj_10844 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int MOD =  1_000_000_000;
        
        int[][] dp = new int[N+1][10];
        
        if(N == 1){
            System.out.println(9);
            return;
        }

        for(int i=1;i<10;i++){
            dp[1][i] = 1;
        }
        
        dp[1][0] = 0;
        
        for(int i=2;i<N+1;i++){
            for(int j=0;j<10;j++){
                if(j==0){ 
                    dp[i][j] = dp[i-1][1] % MOD;
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][8] % MOD;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD) % MOD;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<10;i++){
            sum = (sum + dp[N][i]) % MOD;
        }
        System.out.println(sum);
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


// 11:55
// 인접한 모든 자리의 차이가 1이다.
// N이 주어질때 N인 계단수가 몇개있는지 구해보자
// 0으로 시작하는 수는 계단수가 아니다.
// N은 100보다 작거나 같다.

class boj_10844 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // 0이 한개가 아닐 수 있나?
        // 9가 한개가 아닐 수 있나?
        // 8 -> 9 그러네 그러면 숫자별로 갯수를 관리할 수 있나?
        // dp[i][0] : 0의 갯수? 자릿수가 i 일때

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
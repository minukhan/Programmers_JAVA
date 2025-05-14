import java.util.*;
import java.lang.*;
import java.io.*;

// 10:37
// 2진수열 그에게 타일들을 선물해줬다.
// 0 또는 1이 쓰여있고 
// 동주가 지원이의 00을 만들었음
// 그니까 0은 하나로 못쓰고 00을 붙여서 써야한다는 의미
// N 길이가 주어졌을때 그 길이에 만들 수 있는 이진수의 갯수를 구해라.

class boj_1904 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        int MOD = 15746;
        int[][] dp = new int[N+1][2];
        // 0이 나오려면 2개는 있어야함.
        // dp[i][0] : i번째의 0을사용했을때의 경우의수
        // dp[i][1] : i번째에 1을 사용했을때의 경우의수

        if(N==1){
            System.out.println(1);
            return;
        }
        if(N==2){
            System.out.println(2);
            return;
        }
        
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;


        for(int i=3;i<N+1;i++){
            dp[i][0] = (dp[i-2][0] % MOD + dp[i-2][1]% MOD)% MOD;
            dp[i][1] = (dp[i-1][0] % MOD + dp[i-1][1] % MOD)% MOD;
        }

        
        System.out.println((dp[N][0] + dp[N][1])% MOD);
    }
}
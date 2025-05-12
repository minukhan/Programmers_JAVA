import java.util.*;
import java.lang.*;
import java.io.*;

// dp 문제는 확실히 음.. DP 를 정의를 했을떄 그거대로 시뮬레이션을 도려봐라
// 그러면 생각보다 눈에 쉽게 보인다.
// 그리고 또 주의해야할 점은 오버플로우를 신경써줘야함. 주의!!
class boj_2193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][2];

        
        if(N == 1){
            System.out.println(1);
            return;
        }

        if(N == 2){
            System.out.println(1);
            return;
        }

        dp[1][0] = 0; 
        dp[1][1] = 1;

        dp[2][0] = 1; // 10
        dp[2][1] = 0;

        for(int i=3;i<N+1;i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
        }
        

        long answer = dp[N][0] + dp[N][1];


        
        System.out.println(answer);
    }
}
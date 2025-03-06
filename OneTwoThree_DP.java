import java.util.*;
import java.lang.*;
import java.io.*;

class OneTwoThree_DP {
    public static void OneTwoThree_DP(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<dp.length;i++){
            dp[i] = (dp[i-3]+ dp[i-2]+ dp[i-1]) % 1000000009;
        }

        for(int i=1;i<N+1;i++){
            int value = Integer.parseInt(br.readLine());

            System.out.println(dp[value]);
            
        }

        
    }
}
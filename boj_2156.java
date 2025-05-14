import java.util.*;
import java.lang.*;
import java.io.*;



class boj_2156 {
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1]; 
        // dp[i] : 현재 I번째까지의 최대값.
        // 경우의 수가 3가지밖에 없었음
        // 1. i번째를 먹지 않는경우
        // 2. i-1 번째를 먹지 않고 i번째를 먹는경우
        // 3. i-2 번째를 먹지않고 i-1, i 번째를 먹는경우
        

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 1) dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], 
                        Math.max(dp[i - 2] + wine[i], 
                                 dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}
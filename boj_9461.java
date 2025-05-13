import java.util.*;
import java.lang.*;
import java.io.*;


class boj_9461 {
    public static void main(String[] args) throws IOException{

        
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[100];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        
        for(int i=6;i<100;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        
        StringTokenizer st;
        

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            
            System.out.println(dp[input-1]);
        }
    }
}
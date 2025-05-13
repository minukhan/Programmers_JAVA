import java.util.*;
import java.lang.*;
import java.io.*;



class boj_11052 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<N+1;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<N+1;i++){
            for(int j=1;j<=i;j++){

                dp[i] = Math.max(dp[i] , dp[i-j] + input[j]);
                
            }
        }

        
        System.out.println(dp[N]);
    }
}
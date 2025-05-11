import java.util.*;
import java.lang.*;
import java.io.*;


// 4: 25


class boj_1149 {
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] green = new int[N+1];
        int[] blue = new int[N+1];
        int[] red = new int[N+1];

        int[][] dp = new int[N+1][3];
        
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        

        dp[0][0] = red[0];
        dp[0][1] = green[0];
        dp[0][2] = blue[0];

        for(int i=1;i<N+1;i++){
            dp[i][0] = Math.min(dp[i-1][1] + red[i], dp[i-1][2] + red[i]);
            dp[i][1] = Math.min(dp[i-1][0] + green[i], dp[i-1][2] + green[i]);
            dp[i][2] = Math.min(dp[i-1][1] + blue[i], dp[i-1][0] + blue[i]);
        }
        int min = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

        System.out.println(min);
    }
}
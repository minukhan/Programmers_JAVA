import java.util.*;
import java.lang.*;
import java.io.*;


class boj_15486 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int[] price = new int[N+1];
        int[] time = new int[N+1];
        int[] dp = new int[N+2];
        dp[N+1] = 0;


        for(int i=0;i<N;i++){
            st  = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i+1] = t;
            price[i+1] = p;
        }

        for(int i=N;i>=0;i--){

            dp[i] = dp[i+1]; // 상담 안함

            //상담 가능하면 함
            if(time[i] + i -1 <= N){
                dp[i] = Math.max(dp[i], price[i] + dp[i + time[i]]);
            }
            
        }
        
        
        System.out.println(dp[1]);
    }
}
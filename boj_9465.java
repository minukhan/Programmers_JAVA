import java.util.*;
import java.lang.*;
import java.io.*;


// 2:40


class boj_9465 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T > 0){
    
            int N = Integer.parseInt(br.readLine());
    
            
            int[][] dp = new int[N+1][3];
            int[][] input = new int[3][N+1];
            // dp[i][0] : 스티커를 떼지 않는경우일때 최대값 dp[i-1][0] , 1 ,2
            // dp[i][1] : 스티커 1행부분을 뗄 경우의 최대값 dp[i-1][2] , 0
            // dp[i][2] : 스티커 2행부분을 뗄 경우의 최대값 dp[i-1][1] , 0

            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<N+1;j++){
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = 0;
            dp[1][1] = input[0][1];
            dp[1][2] = input[1][1];
            
            for(int i=2;i<N+1;i++){

                dp[i][0] = Math.max(dp[i-1][0] , Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][2],  dp[i-1][0]) + input[0][i];
                dp[i][2] = Math.max(dp[i-1][1] , dp[i-1][0]) + input[1][i];

            }
            
            int answer = Math.max(dp[N][0] , Math.max(dp[N][1], dp[N][2]));
            

            System.out.println(answer);


            
            T--;
        }
        
    }
}
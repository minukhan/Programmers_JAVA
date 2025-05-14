import java.util.*;
import java.lang.*;
import java.io.*;


// 3:18

// 두개의 나무가 있고 그중 하나의 나무에서 열매가 떨어진다.
// 이때 떨어지는순간 아래에 있으면 그 열매를 받아먹을 수 있음.
// 1초가 움직이는데 들고 최대 W만큼 움직일 수 있음.
// 자두는 T초동안 떨어지고 각각 1, 2번 나무에서 떨어지게됨

// 완탐을 조지면 가능하겠지만 2의 1000승꼴
// -> DP임을 알 수 있음.


class boj_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];

        int[] fall = new int[T+1];
        for (int i = 1; i <= T; i++) {
            fall[i] = Integer.parseInt(br.readLine());
        }

        if(fall[1] == 1){
            dp[1][0] = 1;
        }
        else{
            dp[1][0] = 0;
        }
        
        if (W >= 1) {
            dp[1][1] = (fall[1] == 2 ? 1 : 0);
        }

        for(int i=2;i<T+1;i++){
            for(int j=0;j<W+1;j++){
                //움직이지 않는경우
                dp[i][j] = dp[i-1][j];

                // 움직이는경우
                if(j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }

                
                int where=0;

                if(j % 2 == 0) where = 1;
                else where = 2;

                if(fall[i] == where) dp[i][j]++;
                
            }

            
        }

        int max =0;
        
        for(int i=0;i<W+1;i++){
            max = Math.max(max,dp[T][i]);
        }
        
        
        System.out.println(max);
    }














    
}
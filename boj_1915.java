import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1915 { // 3:00

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        int result = 0;
        
        for(int i=0;i<n;i++){
            String row = br.readLine();
            for(int j=0;j<m;j++){
                int check = row.charAt(j)-'0';

                if(check==0) continue;
                if(i-1<0 || j-1<0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]) , dp[i][j-1]) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        
        System.out.println(result*result);
    }

}

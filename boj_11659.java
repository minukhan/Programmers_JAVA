import java.util.*;
import java.lang.*;
import java.io.*;

class boj_11659 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            int input = Integer.parseInt(st.nextToken());
            dp[i] = dp[i -1] + input;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());

            System.out.println(dp[end] - dp[start - 1]);
            
        }
    }
}
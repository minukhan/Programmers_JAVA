import java.util.*;
import java.lang.*;
import java.io.*;

class boj_13902 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] size = new int[M];
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();

        for (int value : size) {
            if (value <= N) set.add(value);
        }
        
        for(int i=0;i<M;i++){
            for(int j=i+1;j<M;j++){
                int value = size[i] + size[j];
                set.add(value);
            }
        }

        dp[0] = 0;
        
        for(int i=1;i<=N;i++){
            int min = dp[i];
            for(int value : set){

                int check = i-value;
                if(check < 0 || check > N) continue;
                if (dp[check] == Integer.MAX_VALUE) continue;
                min = Math.min(dp[check] + 1, min);
            }

            dp[i] = min;
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
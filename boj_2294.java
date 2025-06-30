import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }


        // coin 의 갯수가 최소.
        // dp[i] i를 만드는데 갯수 최소
        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);

        dp[0] = 0;

        for(int value: list){
            for(int i=value;i<=K;i++){
                dp[i] = Math.min(dp[i-value] + 1, dp[i]);
            }
        }

        System.out.println(dp[K] == 10001 ? -1 : dp[K]);
    }
}

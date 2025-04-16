import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2293 { // 40분
    // 100개를 빽트래킹을 돌려서 경우의수를 찾으려면 시간초과가 날 것 같음.
        // 이러면 DP 로 가야할듯?

        //dp[i-1] + dp[i-5] + dp[i-2] 중복을 제거하면 답.

        // 여기서 DP 유형이 나눠지는듯? 
        // 1. 차례대로 점화식처럼 순서대로 채워지는것.
        // 2. 전체적으로 조금씩 채워지는것.

    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        
        
        dp[0] = 1;
        

        // dp 배열의 순열 생성
        // 1. 차례대로 점화식처럼 순서대로 채워지는것. -> 순열

        // for(int i=1;i<k;i++){
        //     for(int value: money){
        //         if(i >= value){
        //             dp[i] += dp[i-value];
        //         }
        //     }
        // }

        // 2. 전체적으로 조금씩 채워지는것. -> 조합
        
        // dp 배열의 조합 생성
        for (int value : money) {
            for (int i = value; i <= K; i++) {
                dp[i] += dp[i - value];
            }
        }
        
        System.out.println(dp[K]);
            
    }
}
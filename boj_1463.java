import java.util.*;
import java.lang.*;
import java.io.*;


// 9:27

// 정수 X가 있고 할 수 있는 연산은 3가지
// X가 3으로 나누어 떨어지면 3으로 나눈다.
// 2로 나누어떨어지면 2로 나눈다.
// 1을 뺀다.

// 1을 만드려고 함. 최솟값을 구해라.

// N 은 100,000 이므로 뺵트래킹은 안됨.

// BFS는? 될거같은데? 음 나중에 많아지면 안되겠네.

// 이럴때 DP를 생각해야하는 것. 와 시간제한이 0.15초였네

// 어떻게..? 

// 500 3으로 나눠지면 
class boj_1463 {
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        // dp[i] : i값을 1로 만드는데 드는 최소 횟수

        dp[1] = 0;

        for(int i=2;i<N+1;i++){
            dp[i] = dp[i-1] + 1; 

            if(i % 2 == 0 ) dp[i] = Math.min(dp[i] , dp[i / 2] + 1);
            if(i % 3 == 0 ) dp[i] = Math.min(dp[i] , dp[i / 3] + 1);
        }

        System.out.println(dp[N]);
    // 반대로 생각한번 해보기. 습관 들여야겠다.
    // 약간 다익스트라 BFS, DFS는 별로 그런느낌은 없긴한데 항상 생각해보기.
    }
}
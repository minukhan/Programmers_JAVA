import java.util.*;
import java.lang.*;
import java.io.*;


// 9:42

// 수열 A가 주어졌을때 그 수열의 증가하는 부분수열 중에서 합이 가장 큰 것을 구하는 프로그램.
// N은 1000 이므로 n제곱까지 가능하다.
// dp 를 어떻게 정의할 것인가?

// i번째를 포함하는 가장 큰 부분수열의 합?
// 이게 순서대로 dp 가 채워지자나. 그러니까 만족하네
// 이미 이전의 값들은 고려가 다 되어서 합산된 후임. 

// 이전의 합산된 값 + 나의값. 이것만 해주면 dP 끝이네

class boj_11055 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N];
        int[] input = new int[N];

        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = input[i];
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(input[i] > input[j]){
                    dp[i] = Math.max(dp[i] , dp[j] + input[i]);
                }
            }
        }
        int max =0;
        
        for(int i=0;i<N;i++){
            max = Math.max(max, dp[i]);    
        }
        
        
        System.out.println(max);
    }
}
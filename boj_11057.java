import java.util.*;
import java.lang.*;
import java.io.*;


// 12:25

// 자리가 오름차순을 이루는 수
// 인접한 수가 같아도 오름차순으로 친다.
// 수의 길이 N 이 주어졌을때 오르막 수의 갯수를 구하는 프로그램
// 0으로 시작할 수 있고 N 은 1000까지 가능.
// 10,007로 나눈 나머지로 출력
// 일단 완탐하면 되지만 N이 1000이므로 10의 1000 승 불가능

// DP라는 말 -> 이전의 결과가 도움이 되어야함.
// 자릿수로 구분지을 수 있고
// 숫자로 구분지을 수 있음 0, 1, 2, 3,4, ,5, 6 ,7, ,8 ,9
// 형태만 봐서는 둘다 구분지어야 뭐가 풀릴듯?
// 2차원 배열로 정의하자

class boj_11057 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][1001]; // 첫번째인자를 자릿수, 두번째 인자를 숫자
        int MOD = 10007;
        dp[0][0] = 0;

        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        // 그랬을때 답은 모든 값 더하기.
        // dp[i][j]  : i번째 자릿수에서 J를 마지막으로 포함하는 숫자의 갯수
        // 2로끝나는 경우 0번째 + 1번째 + 2번째
        for(int i=2;i<1001;i++){
            for(int j=0 ;j<10;j++){
                int sum = 0;
                for(int k=0;k<=j;k++){
                    sum = (sum% MOD +  dp[i-1][k] % MOD) % MOD;
                }
                dp[i][j] = sum;
            }
        }
        
        int answer = 0;
        
        for(int i=0;i<10;i++){
            answer = (answer % MOD + dp[n][i] % MOD) % MOD; 
        }
        
        System.out.println(answer);
    }
}
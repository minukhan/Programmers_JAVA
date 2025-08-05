
import java.util.*;
import java.lang.*;
import java.io.*;


// N 줄에 0~9 이하의 숫자가 세개씩 적혀있다. 
// 처음에 적혀있는 숫자중에서 하나를 골라서 시작한다. 
// 다음줄로 내려가는데 제약조건이 있다. 
// 바로 아래의 수로 넘어가거나 아니면 바로 아래의 수와 붙어있는 수로만 이동할 수 있다. 
// 인접해있어야 이동할 수 있다는 것. 
// 숫자표가 주어져있을 때, 얻을 수 있는 최대점수, 최소점수를 구하는 프로그램을 작성해라. 
// 원룡이가 위치한 곳의 수의 합이다. 
// 첫재줄에 10만개 까지 있을 수 있다. 
// 최대 점수와 최소 점수를 구하는 프로그램을 작성해라. 
// 10만개라 너무 많은데. 
// 중복 제거를 어떻게 할 수 있지? 
// BFS 를 사용하면 3의 10만승.
// DP? 그리디? 이분탐색? 
// 그리디는 안될 것 같고. DP? 인듯.
// 일단 확실한건 BFS 로는 안됨. 
// 우선순위 큐? 
// 
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int[][] road = new int[N][3];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = road[0][0];
        dp[0][1] = road[0][1];
        dp[0][2] = road[0][2];

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                int max = Integer.MIN_VALUE;

                switch(j){
                    case 0:
                        max = Math.max(max, dp[i-1][0] + road[i][0]);
                        max = Math.max(max, dp[i-1][1] + road[i][0]);
                        break;
                    case 1:
                        max = Math.max(max, dp[i-1][0]+ road[i][1]);
                        max = Math.max(max, dp[i-1][1]+ road[i][1]);
                        max = Math.max(max, dp[i-1][2]+ road[i][1]);
                        break;
                    case 2:
                        max = Math.max(max, dp[i-1][1]+ road[i][2]);
                        max = Math.max(max, dp[i-1][2]+ road[i][2]);
                        break;
                }
                dp[i][j] = max;
            }
        }
        int maxAnswer = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            maxAnswer = Math.max(dp[N-1][i], maxAnswer);
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                int min = Integer.MAX_VALUE;

                switch(j){
                    case 0:
                        min = Math.min(min, dp[i-1][0] + road[i][0]);
                        min = Math.min(min, dp[i-1][1] + road[i][0]);
                        break;
                    case 1:
                        min = Math.min(min, dp[i-1][0]+ road[i][1]);
                        min = Math.min(min, dp[i-1][1]+ road[i][1]);
                        min = Math.min(min, dp[i-1][2]+ road[i][1]);
                        break;
                    case 2:
                        min = Math.min(min, dp[i-1][1]+ road[i][2]);
                        min = Math.min(min, dp[i-1][2]+ road[i][2]);
                        break;
                }
                dp[i][j] = min;
            }
        }

        int minAnswer = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            minAnswer = Math.min(dp[N-1][i], minAnswer);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxAnswer).append(" ").append(minAnswer);
        System.out.println(sb.toString());
        
    }
}
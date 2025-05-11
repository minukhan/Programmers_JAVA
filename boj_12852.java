import java.util.*;
import java.lang.*;
import java.io.*;


// 3:52
// 3으로 나누어 떨어지면 3으로 나눈다.
// 2로 나누어 떨어지면 2로 나눈다.
// 1을 뺸다. 
// N 은 그대로 100,000
// N을 1로 만드는 방법에 포함되어있는 수를 공백으로 구분해서 순서대로 출력하기
// 보통 이런거는 역으로 거슬러 올라가는경우가 많던데
// 
class boj_12852 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] record = new int[N+1];
        dp[1] = 0;

        for(int i=2;i<N+1;i++){
            int index =0;
            dp[i] = dp[i-1] + 1;

            if(i % 2 == 0 ){
                if(dp[i] > dp[i / 2] + 1){
                    index = 1;
                    dp[i] = dp[i / 2] + 1;
                }
                else{
                    index = 0;
                }
            }
            if(i % 3 == 0){
                if(dp[i] > dp[i / 3] + 1){
                    index = 2;
                    dp[i] = dp[i / 3] + 1;
                }
                else{
                }
            }
            record[i] = index;
        }
        
        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        
        int i=N;
        sb.append(N).append(" ");
        
        while(i != 1){
            switch(record[i]){
                case 0:
                    sb.append(i-1).append(" ");
                    i = i -1;
                    break;
                case 1:
                    sb.append(i/2).append(" ");
                    i = i/2;
                    break;
                case 2:
                    sb.append(i/3).append(" ");
                    i = i/3;
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
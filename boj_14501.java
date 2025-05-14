import java.util.*;
import java.lang.*;
import java.io.*;

// 11: 16
// N+1 일째 되는날 퇴사를 하려고한다.
// N일동안 최대한 많은 상담을 하려고한다.
// 하루에 하나씩 서로 다른 사람의 상담을 잡아놈
// 상담을 완료하는데 걸리는 시간 T와 받을 수 있는 금액 P로 되어있음
// 음 기간이랑 값은 다 정해져있는거고. 최대금액으로 쪼개야하는데
// 지금 기간이 잡혀있지.
// 1을 선택하면 dp[4] = 10
// 모르겠으면 뒤집어 보라고..


// The main method must be in a class named "Main".
class boj_14501 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int[] price = new int[N+1];
        int[] time = new int[N+1];
        int[] dp = new int[N+2];
        dp[N+1] = 0;
        // dp[i] : i번째일때의 최대값 
        // i에서부터 N까지 얻을 수 있는 최대값.
        // answer 은 

        for(int i=0;i<N;i++){
            st  = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i+1] = t;
            price[i+1] = p;
        }

        for(int i=N;i>=0;i--){

            dp[i] = dp[i+1]; // 상담 안함

            //상담 가능하면 함
            if(time[i] + i -1 <= N){
                dp[i] = Math.max(dp[i], price[i] + dp[i + time[i]]);
            }
            
        }
        
        
        System.out.println(dp[1]);
    }
}
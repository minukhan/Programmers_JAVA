import java.util.*;
import java.lang.*;
import java.io.*;


// 11:38

// 피보나치 수를 음수인 경우로도 확장을 시키고 싶어함.
// 절대값은 100만을 넘지 않는다.
// 

class boj_1788 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int N = 1000000;
        
        int[] dp = new int[N+1];
        int[] minusDp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<N+1;i++){
            dp[i] = (dp[i-1] % 1000000000 + dp[i-2] % 1000000000) %1000000000;
        }

        minusDp[1] = 1;
        minusDp[2] = -1;
        
        for(int i=3;i<N+1;i++){
            minusDp[i] = (minusDp[i-2] % 1000000000 - minusDp[i-1] % 1000000000) & 1000000000 ; 
        }

        
        if(n < 0){
            int result = n * -1;
            if(minusDp[result] > 0){
                System.out.println(1);
            }
            else if (minusDp[result] == 0){
                System.out.println(0);
            }
            else{
                System.out.println(-1);
            }
            
            System.out.println(Math.abs(minusDp[result]));
        }
        else{
            if(dp[n] > 0){
                System.out.println(1);
            }
            else if (dp[n] == 0){
                System.out.println(0);
            }
            else{
                System.out.println(-1);
            }
            
            System.out.println(Math.abs(dp[n]));
        }
        
    }
}



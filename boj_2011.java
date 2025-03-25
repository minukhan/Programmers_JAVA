import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2011 {

    public static int[] numberArr;
    public static int[] dp;
    public static int count=0;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();

       numberArr = new int[code.length()];
        for(int i=0;i<numberArr.length;i++){
            numberArr[i] = code.charAt(i) - '0';
        }
        
        dp = new int[code.length() + 1];

        if(numberArr[0] == 0){
            System.out.println("0");
            return;
        }

        dp[0] = 1; // dp[i-2] 를 하기위해 임의로 만듬.
        dp[1] = 1;

        for(int i=2;i<dp.length;i++){
            if(numberArr[i-1] != 0){
                dp[i] = (dp[i] + dp[i-1]) % 1000000;
            }

            int num = numberArr[i-2] * 10 + numberArr[i-1];
            if(num >= 10 && num <= 26){
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }

        System.out.println(dp[code.length()]);
    }
}
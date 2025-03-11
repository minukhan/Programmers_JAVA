import java.util.*;
import java.lang.*;
import java.io.*;

class TLS { 
    public static void TLS(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        int[] dp = new int[n];

        Arrays.fill(dp,1); // dp라는 배열을 1로 초기화 
        // -> dp 배열을 현재 인덱스를 포함하는 가장 긴 부분수열로 설정.
        

        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int max =1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        

        
        System.out.println(max);
    }
}
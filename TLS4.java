import java.util.*;
import java.lang.*;
import java.io.*;

class TLS4 { 
    public static void TLS4(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        int[] dp = new int[n];
        int[] trace = new int[n];

        Arrays.fill(trace,-1);
        Arrays.fill(dp,1); // dp라는 배열을 1로 초기화 
        // -> dp 배열을 현재 인덱스를 포함하는 가장 긴 부분수열로 설정.
        
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(A[i] > A[j]){
                    if(dp[i] < dp[j] + 1){
                        trace[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int lastIndex =-1;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        
        int traceNumber = lastIndex;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(traceNumber != -1){
            list.add(A[traceNumber]);
            traceNumber = trace[traceNumber];
        }

        Collections.reverse(list);
        int len = list.size();
        
        StringBuilder sb = new StringBuilder();

        for(int value: list){
            sb.append(value).append(" ");
        }
        System.out.println(len);
        System.out.println(sb.toString());
    }
}
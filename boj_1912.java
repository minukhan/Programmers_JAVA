import java.util.*;
import java.lang.*;
import java.io.*;


class boj_1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        int maxSum = -100000;
        int currentSum = -10000;

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            maxSum = Math.max(maxSum, arr[i]);
        }

        currentSum = arr[0];
        for(int i = 1; i < N; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}

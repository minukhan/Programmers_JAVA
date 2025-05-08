import java.util.*;
import java.io.*;

class boj_12015 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int length = 0;         

        for (int i = 0; i < N; i++) {
            int idx = binarySearch(dp, 0, length, number[i]);
            dp[idx] = number[i];

            if (idx == length) length++;
        }

        System.out.println(length);
    }


    public static int binarySearch(int[] dp, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

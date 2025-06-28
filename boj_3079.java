import java.io.*;
import java.util.*;

public class boj_3079 {
    public static int N;
    public static long M;
    public static long[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        time = new long[N];
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            time[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, time[i]);
        }

        long left = 1;
        long right = maxTime * M;

        long answer = binarySearch(left, right);
        System.out.println(answer);
    }

    public static long binarySearch(long L, long R) {

        while (L <= R) {
            
            long mid = L + (R - L) / 2;
            long sum = 0;
            
            for (int i = 0; i < N; i++) {
                sum += mid / time[i];
                if (sum >= M) break;  
            }

            if (sum < M) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return L;
    }
}

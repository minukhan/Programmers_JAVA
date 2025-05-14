import java.util.*;
import java.lang.*;
import java.io.*;

public class boj_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[M+2];

        vip[0] = 0;
        for (int i = 1; i <= M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        vip[M+1] = N + 1;

        long[] fib = new long[N+1];
        fib[0] = 1;  
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        long ans = 1;
        for (int j = 1; j < vip.length; j++) {
            int len = vip[j] - vip[j-1] - 1;
            ans *= fib[len];
        }

        System.out.println(ans);
    }
}

import java.util.*;
import java.io.*;

class boj_11501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int maxPrice = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }

            System.out.println(profit);
        }
    }
}


import java.util.*;
import java.io.*;

class boj_25682 {
    public static int[][] bDp;
    public static int[][] wDp;
    public static int N;
    public static int M;
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bDp = new int[N][M];
        wDp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char current = input.charAt(j);
                char bValue = ((i + j) % 2 == 0) ? 'B' : 'W';
                char wValue = ((i + j) % 2 == 0) ? 'W' : 'B';

                bDp[i][j] = (current != bValue) ? 1 : 0;
                wDp[i][j] = (current != wValue) ? 1 : 0;

                if (i > 0) {
                    bDp[i][j] += bDp[i - 1][j];
                    wDp[i][j] += wDp[i - 1][j];
                }
                if (j > 0) {
                    bDp[i][j] += bDp[i][j - 1];
                    wDp[i][j] += wDp[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    bDp[i][j] -= bDp[i - 1][j - 1];
                    wDp[i][j] -= wDp[i - 1][j - 1];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i + K - 1 < N; i++) {
            for (int j = 0; j + K - 1 < M; j++) {
                min = Math.min(min, Bcount(i, j, K));
                min = Math.min(min, Wcount(i, j, K));
            }
        }

        System.out.println(min);
    }

    public static int Bcount(int y, int x, int size) {
        int y2 = y + size - 1;
        int x2 = x + size - 1;

        int total = bDp[y2][x2];
        if (y > 0) total -= bDp[y - 1][x2];
        if (x > 0) total -= bDp[y2][x - 1];
        if (y > 0 && x > 0) total += bDp[y - 1][x - 1];

        return total;
    }

    public static int Wcount(int y, int x, int size) {
        int y2 = y + size - 1;
        int x2 = x + size - 1;

        int total = wDp[y2][x2];
        if (y > 0) total -= wDp[y - 1][x2];
        if (x > 0) total -= wDp[y2][x - 1];
        if (y > 0 && x > 0) total += wDp[y - 1][x - 1];

        return total;
    }
}

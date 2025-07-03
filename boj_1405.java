import java.util.*;
import java.lang.*;
import java.io.*;

public class boj_1405 {
    static int N;
    static double[] prob = new double[4]; // 동서남북
    static boolean[][] visited = new boolean[29][29];
    static double answer = 0.0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        visited[14][14] = true; // 시작지점
        dfs(14, 14, 0, 1.0);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int depth, double currentProb) {
        if (depth == N) {
            answer += currentProb;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (visited[ny][nx] || prob[i] == 0) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1, currentProb * prob[i]);
            visited[ny][nx] = false;
        }
    }
}

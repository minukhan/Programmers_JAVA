import java.util.*;
import java.io.*;

class boj_16986 {
    public static int N, K;
    public static int[][] rule;
    public static int[] visited;   
    public static int[][] data;   
    public static int[] jiwoo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rule = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rule[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        data = new int[2][20];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                data[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        visited = new int[N];
        jiwoo  = new int[N];
        dfs(0);

        System.out.println(0);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            simulate();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            jiwoo[depth] = i;
            dfs(depth + 1);
            visited[i] = 0;
        }
    }

    public static void simulate() {
        int[] win = new int[3];  
        int[] idx = new int[3];
        int p1 = 0, p2 = 1, wait = 2;
        int rounds = 0;

        while (rounds < 20 && win[0] < K && win[1] < K && win[2] < K) {

            int m1 = change(p1, idx);
            int m2 = change(p2, idx);
            int winner = whoWin(p1, m1, p2, m2);
            win[winner]++;
            rounds++;

            if (win[0] == K) {
                System.out.println(1);
                System.exit(0);
            }

            int loser = (winner == p1 ? p2 : p1);
            p1 = winner;
            p2 = wait;
            wait = loser;
        }
    }

    private static int change(int p, int[] idx) {
        if (p == 0) return jiwoo[idx[0]++];
        else         return data[p - 1][idx[p]++];
    }

    private static int whoWin(int p1, int m1, int p2, int m2) {
        if (check(m1, m2)) return p1;
        if (rule[m1][m2] == 1) {
            return Math.max(p1, p2);
        }
        return p2;
    }

    public static boolean check(int first, int second) {
        switch (rule[first][second]) {
            case 2: return true;
            case 1: return false;
            case 0: return false;
        }
        return false;
    }
}

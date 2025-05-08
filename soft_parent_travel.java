import java.util.*;
import java.lang.*;
import java.io.*;

class soft_parent_travel {

    static class Edge {
        int index;
        char road;
        public Edge(int index, char road) {
            this.index = index;
            this.road = road;
        }
    }

    public static List<Edge>[] list;
    public static String happy;
    public static int N, M;
    public static boolean[] visited;
    public static int[][] dp;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        happy = br.readLine();

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            char road = st.nextToken().charAt(0);

            // 양방향 간선
            list[from].add(new Edge(to, road));
            list[to].add(new Edge(from, road));
        }

        visited = new boolean[N + 1];
        dp = new int[N + 1][happy.length() + 1];

        visited[1] = true;
        dfs(0, 1);

        System.out.println(max);
    }

    public static void dfs(int depth, int node) {
        boolean isLeaf = true;

        for (Edge edge : list[node]) {
            int next = edge.index;
            if (!visited[next]) {
                isLeaf = false;
                visited[next] = true;

                // 이전 dp[depth][*]를 기반으로 dp[depth+1][*] 계산
                for (int j = 0; j < happy.length(); j++) {
                    if (edge.road == happy.charAt(j)) {
                        dp[depth + 1][j + 1] = dp[depth][j] + 1;
                    } else {
                        dp[depth + 1][j + 1] = Math.max(dp[depth][j + 1], dp[depth + 1][j]);
                    }
                }

                dfs(depth + 1, next);


                for (int j = 1; j <= happy.length(); j++) {
                    dp[depth + 1][j] = 0;
                }
                visited[next] = false;
            }
        }

        if (isLeaf) {
            for (int j = 1; j <= happy.length(); j++) {
                max = Math.max(max, dp[depth][j]);
            }
        }
    }
}

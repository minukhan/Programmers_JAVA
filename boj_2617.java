import java.util.*;
import java.io.*;

public class boj_2617 {
    public static int N, M;
    public static List<Integer>[] graph;     
    public static List<Integer>[] revGraph;  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph    = new ArrayList[N + 1];
        revGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i]    = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            revGraph[a].add(b);
        }

        int cannotBeMiddle = 0;
        int half = N / 2;

        for (int i = 1; i <= N; i++) {
            int heavyCount = bfsCount(i, graph);
            if (heavyCount > half) {
                cannotBeMiddle++;
                continue;  
            }

            int lightCount = bfsCount(i, revGraph);
            if (lightCount > half) {
                cannotBeMiddle++;
            }
        }

        System.out.println(cannotBeMiddle);
    }

    static int bfsCount(int start, List<Integer>[] g) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : g[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    count++;
                    if (count > N / 2) {
                        return count;
                    }
                    queue.add(v);
                }
            }
        }
        return count;
    }
}

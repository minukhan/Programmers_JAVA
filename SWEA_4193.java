import java.util.*;
import java.io.*;

public class SWEA_4193 {

    static class Node {
        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N;
    static int[][] road;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Node start, end;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        StringTokenizer st;
        int index = 1;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            road = new int[N][N];
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    road[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            sb.append("#").append(index).append(" ");
            bfs();
            sb.append("\n");
            index++;
        }

        System.out.print(sb.toString());
    }

    public static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>(
        		(o1,o2) -> Integer.compare(o1.time, o2.time)
        		);
        
        visited = new int[N][N];
        queue.add(start);
        visited[start.y][start.x] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

           
            if (node.y == end.y && node.x == end.x) {
                sb.append(node.time);
                return;
            }

            int nextTime = node.time + 1;

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (road[ny][nx] == 1) continue;
                if(visited[ny][nx] != 0) continue;
                
                if (road[ny][nx] == 2) {
     
                    visited[ny][nx] = 1;
                    int waitTime = 2 - node.time%3 ;

                    queue.add(new Node(ny, nx, waitTime + nextTime));

                } else {
                    
                    visited[ny][nx] = 1;
                    queue.add(new Node(ny, nx, nextTime));
               
                }
            }
        }

        sb.append(-1);
    }


}

import java.util.*;
import java.lang.*;
import java.io.*;


class boj_16933 {
    public static int N;
    public static int M;
    public static int K;
    public static boolean[][][][] visited;
    public static int[][] map;
    public static int[] dx = {0,0,-1, 1}; 
    public static int[] dy = {1,-1,0,0};

    static class Node{
        int x;
        int y;
        int count;
        int dark;
        int broken;
        public Node(int x, int y, int count, int broken, int dark){
            this.x = x;
            this.y = y;
            this.count = count;
            this.broken = broken;
            this.dark = dark;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[K+1][N][M][2];
        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
        
        System.out.println(-1);
    }

    public static int change(int dark){
        switch(dark){
            case 1:
                return 0;
            case 0:
                return 1;
        }
        return -1;
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,0,0,0));
        visited[0][0][0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int darkChange = change(node.dark);

            if(node.x == M-1 && node.y == N-1){
                System.out.println(node.count+1);
                System.exit(0);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            
                int nd = 1 - node.dark;
            
                // 1) 빈 칸
                if (map[ny][nx] == 0) {
                    if (!visited[node.broken][ny][nx][nd]) {
                        visited[node.broken][ny][nx][nd] = true;
                        queue.add(new Node(nx, ny,
                                           node.count + 1,
                                           node.broken, nd));
                    }
                    continue;
                }
            
                // 벽
                if (node.dark == 0) {
                    // 낮에만 부술 수 있음
                    if (node.broken < K
                        && !visited[node.broken+1][ny][nx][nd]) {
                        visited[node.broken+1][ny][nx][nd] = true;
                        queue.add(new Node(nx, ny,node.count + 1,node.broken + 1, nd));
                    }
                } else {
                    // 밤에는 이동 불가
                    if (!visited[node.broken][node.y][node.x][nd]) {
                        visited[node.broken][node.y][node.x][nd] = true;
                        queue.add(new Node(node.x, node.y,node.count + 1,node.broken, nd));
                    }
                }
            }
            
        }
        
    }
}
























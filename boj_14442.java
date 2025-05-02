import java.util.*;
import java.lang.*;
import java.io.*;


// 3:01
// 맵에서 0은 이동할 수 있는곳
// 1은 이동할 수 없는 벽을 말함.
// 1,1 에서 N,M 까지 이동하려하는데 최단경로로 이동하려함. -> BFS?
// 시작하는 칸과 끝나는 칸도 포함임.
// 벽을 부술 수 있는데 K개까지 부술 수 있다. 
// 상하좌우로 이동할 수 있고 
/// 최단경로를 구해라. K는 10까지 가능. 
// N,M 은 1000 까지 가능
// 원래는 visited[][][] 배열을 이용해서 0 이면 사용안한채 1이면 사용한채로 ~
// 근데 이제 갯수가 늘어났음 그냥 첫번째 배열을 사용한 갯수로 가져가면 되나?
// min visited[] 배열
// 1,000 * 1,000 * 10 메모리 복잡도 40,000,000 가능


class boj_14442 {

    public static int N;
    public static int M;
    public static int K;
    public static int[] dx = {0,0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[][] map;
    public static int[][][] visited;

    static class Node{
        int x;
        int y;
        int broken;
        int count;
        public Node(int x, int y, int broken, int count){
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[K+1][N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean check = false;

        queue.add(new Node(0,0,0,1));
        visited[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == M-1 && node.y == N-1){
                System.out.println(node.count);
                check=true;
                break;
            }

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >=M || ny < 0 || ny >=N) continue;
                if(visited[node.broken][ny][nx] == 1) continue;
                if(map[ny][nx] == 1){
                    if(node.broken+1 <= K && visited[node.broken +1][ny][nx] == 0){
                        queue.add(new Node(nx,ny,node.broken +1,node.count +1));
                        visited[node.broken +1][ny][nx] = 1;
                    }

                    continue;
                }

                queue.add(new Node(nx,ny,node.broken,node.count +1));
                visited[node.broken][ny][nx] = 1;
            }
        }

        if(!check){
            System.out.println(-1);
        }
    }
}

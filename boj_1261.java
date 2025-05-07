import java.util.*;
import java.lang.*;
import java.io.*;


class boj_1261 {

    public static int N;
    public static int M;
    public static int count=0;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};
    public static int[][] map;
    public static int[][] visited;
    public static ArrayList<Node> list;

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        list.add(new Node(0,0));
        visited[0][0] = 1;

        while(true){
            bfs();
            count++;
        }
        
    }


    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        for(Node node : list){
            queue.add(node);
        }

        list.clear();

        while(!queue.isEmpty()){
            Node node  = queue.poll();

            if(node.y == N-1 && node.x == M-1){
                System.out.println(count);
                System.exit(0);
            }

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] == 1) continue;
                if(map[ny][nx] == 1){
                    list.add(new Node(nx,ny));
                    visited[ny][nx] = 1;
                    continue;
                }

                queue.add(new Node(nx,ny));
                visited[ny][nx] = 1;
            }
        }
    }
}
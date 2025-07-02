import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2665 {

    public static int N;
    public static int[][] map;
    public static int[][][] visited;
    public static int min = Integer.MAX_VALUE;

    static class Node{
        int x;
        int y;
        int count;
        public Node(int y,int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        map = new int[N][N];
        visited = new int[N*N][N][N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        bfs();

        System.out.println(min);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,0));
        visited[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == N-1 && node.y == N-1){
                min = Math.min(min, node.count);
                continue;
            }
            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(visited[node.count][ny][nx] == 1) continue;

                if(map[ny][nx] == 0){
                    if(node.count+1 < N*N && visited[node.count + 1][ny][nx] != 1){
                        queue.add(new Node(ny,nx,node.count+1));
                        visited[node.count+1][ny][nx] = 1;
                    }
                    continue;
                }

                queue.add(new Node(ny,nx,node.count));
                visited[node.count][ny][nx] = 1;
            }
        }
    }
}
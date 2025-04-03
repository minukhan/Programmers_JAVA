import java.util.*;
import java.lang.*;
import java.io.*;
// 1시간 4분
class boj_2206 {

    public static int N;
    public static int M;
    public static int[][][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int[][] road;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M][2]; // y, x , 벽을 뿌순 상태 사용

        for(int[][] value : visited){
            for(int [] row : value){
                Arrays.fill(row,-1);
            }
        }

        road = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            
            for(int j=0;j<M;j++){
                road[i][j] = row.charAt(j) - '0';
            }
        }

        bfs();
        int answer = visited[N-1][M-1][0];
        int breakAnswer = visited[N-1][M-1][1];

        if(answer == -1){
            System.out.println(breakAnswer);
        }
        else if(breakAnswer == -1){
            System.out.println(answer);
        }
        else{
            System.out.println(Math.min(answer, breakAnswer));
        }
        
    }
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0, 0));
        visited[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int boom = node.broken;
                
                if(nx <0 || ny < 0 || ny >=N || nx >= M) continue;
                if(visited[ny][nx][node.broken] != -1) continue;
                if(road[ny][nx] == 1){
                    if(boom == 1) continue;
                    boom = 1;
                }

                queue.add(new Node(nx,ny,boom));
                visited[ny][nx][boom] = visited[y][x][node.broken] + 1;
            }
        }
    }

    static class Node{
        int x;
        int y;
        int broken;

        public Node(int x, int y, int broken){
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


//11:17

// 체스판 위에 나이트가 있다.
// 몇번 움직이면 이동하려고 하는 칸에 도착할까?
// 딱 보니까 이게 최소값도 최소값인데 하나가 깊게 들어가면 무한히 돌 수 있을때 dfs 를 안쓰네
// 한 변의 길이 I 가 주어지고 체스판의 크기는 I* I, 둘째 줄 : 나이트가 있는 칸
// 셋째 줄 : 나이트가 이동하려는 칸 


class boj_7562 {
    public static int N;
    public static int startX;
    public static int startY;
    public static int endX;
    public static int endY;
    public static int[] dx = {-2,-1,1,2,-2,-1,1,2};
    public static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static int[][] visited;
    
    static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


         while(T > 0){
             N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
             startX = Integer.parseInt(st.nextToken());
             startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
             endX = Integer.parseInt(st.nextToken());
             endY = Integer.parseInt(st.nextToken());
            visited = new int[N][N];
             
             bfs();
             
             T--;
         }
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX, startY,0));
        visited[startY][startX] = 1;


        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == endX && node.y == endY){
                System.out.println(node.count);
                break;
            }
            
            for(int i=0;i<8;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];


                // 범위처리
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // visited 처리
                if(visited[ny][nx] == 1) continue;

                visited[ny][nx] = 1;
                queue.add(new Node(nx,ny,node.count+1));
            }
        }
    }
}
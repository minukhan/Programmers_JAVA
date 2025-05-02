import java.util.*;
import java.lang.*;
import java.io.*;



// 5:00

// 보관한 후 하루가 지나면 익은 토마토들의 인접한곳의 토마토들은 익어버리게됨
// 3차원이네
// 다 익게되는 날이 몇일인지 
// 일부 칸에는 토마토가 들어있지 않을 수 있다. 갈 수 없다는 뜻.
// 가로 세로 높이 100 까지 가능
// 1은 모두 익은 토마토
// 0은 익지않은 토마토
// -1 없는곳

class boj_7569 {

    public static int N;
    public static int count=0;
    public static int M;
    public static int H;
    public static int[][][] box;
    public static int[][][] visited;
    public static int[] dx = {0,0,1,-1,0,0};
    public static int[] dy = {1,-1,0,0,0,0};
    public static int[] dz = {0,0,0,0,-1,1};
    public static ArrayList<Node> list;

    static class Node{
        int x;
        int y;
        int z;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        
        box = new int[H][N][M];
        visited = new int[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) list.add(new Node(k,j,i));
                }
            }
        }

        bfs();
    }

    public static void bfs(){

        boolean no = false;
        Queue<Node> queue = new LinkedList<>();

        for(Node node : list){
            queue.add(node);
            visited[node.z][node.y][node.x] = 1;
        }


        while(!queue.isEmpty()){
            int size = queue.size();

            if(check()){
                System.out.println(count);
                no = true;
                break;
            }
            
            while(size-- > 0){

                Node node = queue.poll();

                for(int i=0;i<6;i++){
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    int nz = node.z + dz[i];

                    if(nx < 0 || nx >=M || nz < 0 || nz >= H || ny < 0 || ny >=N) continue;
                    if(visited[nz][ny][nx] == 1) continue;
                    if(box[nz][ny][nx] == -1 || box[nz][ny][nx] == 1) continue;

                    visited[nz][ny][nx] = 1;
                    box[nz][ny][nx] = 1;
                    queue.add(new Node(nx,ny,nz));
                }
            }
            count++;
        }

        if(!no){
            System.out.println(-1);
        }
    }
    public static boolean check(){

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){

                    if(box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;



class soft_tree_exit {
    
    static class Node{
        int y;
        int x;
        int ghost;
        public Node(int y, int x, int ghost){
            this.y= y;
            this.x= x;
            this.ghost = ghost;
        }
    }

    public static Node start;
    public static Node exit;
    public static int N;
    public static int M;
    public static char[][] maze;
    public static int[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static ArrayList<Node> list;
    
    
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        maze = new char[N][M];
        visited = new int[N][M];
        list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j=0;j<M;j++){
                maze[i][j] = input.charAt(j);

                if(maze[i][j] == 'N'){
                    start = new Node(i,j,0);
                }
                if(maze[i][j] == 'D'){
                    exit = new Node(i,j,0);
                }
                if(maze[i][j] == 'G'){
                    list.add(new Node(i,j,1));
                }
            }
        }

        

        bfs();
        
    }

    // # : 벽
    // G : 유령
    // . : 빈칸
    // start : 시작
    // exit : 탈출

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited[start.y][start.x] = 1;

        for(Node node : list){
            queue.add(node);
            visited[node.y][node.x] = 1;
            maze[node.y][node.x] = 'G';
        }

    

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(maze[node.y][node.x] == 'D'){
                System.out.println("Yes");
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                boolean gogo = false;
                if(node.ghost ==1){
                    gogo = true;
                }

                
                if(visited[ny][nx] == 1){
                    if(!gogo){
                        continue;
                    }
                }
                
                if(maze[ny][nx] == 'G') continue;

                //벽체크 유령이면 상관없음 
                
                // 유령이 아니고 벽이라면
                if(maze[ny][nx] == '#'){
                    // 유령이 아니라면 continue
                    if(!gogo){
                        continue;
                    }
                }

                if(gogo) maze[ny][nx] = 'G';

                
                queue.add(new Node(ny,nx,node.ghost));
                visited[ny][nx] = 1;
            
            }
        }

        System.out.println("No");
        
    }
}
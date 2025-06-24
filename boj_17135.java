import java.util.*;
import java.lang.*;
import java.io.*;

class boj_17135 {

    public static int N;
    public static int M;
    public static int answer=0;
    public static int max=0;
    public static int D;
    public static int[][] road;
    public static int[][] copy;
    public static int[] position;
    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {0, -1, 0};

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        road = new int[N+1][M];
        copy = new int[N+1][M];
        position = new int[M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0);

        System.out.println(max);
    }

    public static void dfs(int count, int index){
        // 조합? 중복 x
        if(count == 3){
            simulation();
            return;
        }

        for(int i=index;i<M;i++){
            position[i] = 1;
            dfs(count + 1, i + 1);
            position[i] = 0;
        }
    }

    public static void simulation(){

        // copy 배열 하나 생성
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy[i][j] = road[i][j];
            }
        }

        // 다 돌리기.
        while(true){

            HashSet<String> set = new HashSet<>();
            
            // bfs로 거리 내의 적 찾기
            for(int i=0;i<M;i++){
                if(position[i] == 1){
                    Node find = bfs(i);

                    if(find == null) continue;
                    String ch = find.y + "," + find.x;

                    if(!set.contains(ch)){
                        set.add(find.y + "," + find.x);
                    }
                }
            }

            for(String c : set){
                String[] arr = c.split(",");
                int y = Integer.parseInt(arr[0]);
                int x = Integer.parseInt(arr[1]);
                
                if(copy[y][x] == 1){
                    copy[y][x] = 0;
                    answer++;
                }
            }
            
            //밑으로 한 칸씩 밀기.
            move();

            // 적이 있는지 없는지 체크.
            if(!check()){
                break;
            }
        }
        
        max = Math.max(answer, max);
        answer =0;
    }
    
    public static Node bfs(int x){
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[N+1][M];
        
        queue.add(new Node(N,x));
        visited[N][x] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(copy[node.y][node.x] == 1){
                return new Node(node.y,node.x);
            }

            for(int i=0;i<3;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] == 1) continue;
                if(distance(ny,nx, N, x) > D) continue;
                
                visited[ny][nx] = 1;
                queue.add(new Node(ny,nx));
            }
        }

        return null;
    }
    
    public static int distance(int y1, int x1, int y2, int x2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
    
    public static void move(){
        for(int i=N-1;i>0;i--){
            for(int j=0;j<M;j++){
                copy[i][j] = copy[i-1][j];
            }
        }

        for(int j=0;j<M;j++){
            copy[0][j] = 0;
        }    
    }
    
    public static boolean check(){
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 1){
                    return true;
                }
            }
        }

        return false;
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

        
class boj_1941 { // 2 :46

    public static int[][] road;
    public static int answer;
    public static int[][] visited;
    public static int[][] bfsVisited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        road = new int[5][5];
        visited = new int[5][5];
        bfsVisited = new int[5][5];
        
        for(int i=0;i<5;i++){ // 1 이면 이다솜
            st = new StringTokenizer(br.readLine());
            String mem = st.nextToken();
            for(int j=0;j<5;j++){

                char member = mem.charAt(j);
                
                if(member=='Y'){
                     road[i][j] = 0;
                }
                else{
                     road[i][j] = 1;
                }
            }
        }

        dfs(0,0,0);
        
        System.out.println(answer);
    }

    public static void dfs(int count, int index, int sum){

        if(count == 7){
            if(sum >= 4 && bfs()){
                answer++;
            }
            return;
        }

        for(int i=index;i<25;i++){
            int x = i/5;
            int y = i%5;

            if(visited[y][x] == 1) continue;

            visited[y][x] = 1;
            dfs(count + 1, i + 1,sum + road[y][x]);
            visited[y][x] = 0;
                
        }
    }

    public static boolean bfs(){

        for(int[] value : bfsVisited){
            Arrays.fill(value,0);
        }
        
        int bfsCount =0;
        int x = -1;
        int y = -1;

        boolean check = true;
        for(int i=0;i<5 && check;i++){
            for(int j=0;j<5;j++){
                if(visited[i][j] == 1){
                    x = j;
                    y = i;
                    check = false;
                    break;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        bfsVisited[y][x] = 1;
        queue.add(x);
        queue.add(y);
        bfsCount++;
        
        while(!queue.isEmpty()){
            int xNum = queue.poll();
            int yNum = queue.poll();

            for(int i=0;i<4;i++){
                int nx = dx[i] + xNum;
                int ny = dy[i] + yNum;

                if(nx < 0 || ny < 0 || nx > 4 || ny > 4) continue;
                if(visited[ny][nx] == 0) continue;
                if(bfsVisited[ny][nx] == 1) continue;

                bfsVisited[ny][nx] = 1;
                queue.add(nx);
                queue.add(ny);
                bfsCount++;
            }
        }

        if(bfsCount != 7) return false;
        
        return true;
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class boj_14502 {

    public static int N;
    
    static class Node{
        int x;
        int y;
        public Node(int y, int x){
            this.y =y;
            this.x = x;
        }
    }
    public static ArrayList<Node> list;
    public static ArrayList<Node> virus;
    public static int[][] road;
    public static int[][] record;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int max = Integer.MIN_VALUE;
    public static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        virus = new ArrayList<>();
        
        road = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
                if(road[i][j] == 0) list.add(new Node(i,j));
                if(road[i][j] == 2) virus.add(new Node(i,j));
            }
        }
        record = new int[3][2];

        dfs(0,0);

        System.out.println(max);
    }

    public static void bfs(){
        int[][] visited = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = road[i][j];
            }
        }

        for(int i=0;i<3;i++){
            int y = record[i][0];
            int x = record[i][1];

            visited[y][x] = 1;
        }

        Queue<Node> queue = new LinkedList<>();

        for(Node node : virus){
            queue.add(node);
            visited[node.y][node.x] = 2;
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(ny < 0 || ny >=N || nx < 0 || nx >=M ) continue;
                if(visited[ny][nx] != 0) continue;

                queue.add(new Node(ny,nx));
                visited[ny][nx] = 2;
            }
        }

        int answer = count(visited);
        
        max = Math.max(max, answer);
    }
    
    public static void dfs(int count, int index){
        
        if(count == 3){
            bfs();
            return;
        }
        
        for(int i=index;i<list.size();i++){
            Node node = list.get(i);
            record[count][0] = node.y;
            record[count][1] = node.x;
            
            dfs(count + 1, i+1);
        }
    }

    public static int count(int[][] visited){
        int count =0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j] == 0) count++;
            }
        }
        return count;
    }
}
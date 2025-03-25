import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1600 {

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int[] horseDx = {-1,-2,1,2, -2, -1,1,2};
    public static int[] horseDy = {-2,-1,-2,-1, 1 ,2,2,1};
    public static int[][] road;
    public static int W;
    public static int H;
    public static int K;
    public static int[][][] visited;
    
    static class Node{

        int x;
        int y;
        int move;
        int horseCount;
        
        public Node(int x,int y,int move,int horseCount){
            this.x = x;
            this.y = y;
            this.move = move;
            this.horseCount = horseCount;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
    
         W = Integer.parseInt(st.nextToken());
         H = Integer.parseInt(st.nextToken());
        
         road = new int[H][W];
        visited = new int[H][W][K+1];

        for(int[][] arr : visited){
            for(int[] row : arr){
                Arrays.fill(row,Integer.MAX_VALUE);
            }
        }
        
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<W;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       
        bfs();
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<K+1;i++){
            min = Math.min(min,visited[H-1][W-1][i]);
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 :min);
    }

    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,0,K));
        visited[0][0][K] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<dx.length;i++){
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                int count = node.horseCount;

                if(x<0 || x>=W) continue;
                if(y<0 || y>=H) continue;
                if(visited[y][x][count] != Integer.MAX_VALUE) continue;
                if(road[y][x] == 1) continue;

                queue.add(new Node(x,y,node.move + 1,node.horseCount));
                visited[y][x][count] = node.move + 1;
            }
            
            if(node.horseCount <= 0) continue;

            for(int i=0;i<horseDx.length;i++){
                
                int x = node.x + horseDx[i];
                int y = node.y + horseDy[i];
                int count = node.horseCount;

                if(x<0 || x>=W) continue; 
                if(y<0 || y>=H) continue;
                if(visited[y][x][count-1] != Integer.MAX_VALUE) continue;
                if(road[y][x] == 1) continue;
                
                queue.add(new Node(x,y,node.move + 1,node.horseCount - 1));
                visited[y][x][count-1] = node.move + 1;
            }
        }
    }
}
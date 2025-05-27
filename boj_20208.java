import java.util.*;
import java.lang.*;
import java.io.*;


class boj_20208 {

    public static int[] dx = {0,0, -1, 1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] road;
    public static int[] visited;
    public static int N;
    public static int M;
    public static int H;
    public static int startX;
    public static int startY;
    public static int max = Integer.MIN_VALUE;
    public static ArrayList<Node> list;

    static class Node{
        int y;
        int x;
        public Node(int y,int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         H = Integer.parseInt(st.nextToken());

        road = new int[N][N];
        list = new ArrayList<>();
        
         startX = 0;
         startY = 0;
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                road[i][j] = Integer.parseInt(st.nextToken());

                if(road[i][j] == 2){
                    list.add(new Node(i,j));
                }
                else if(road[i][j] == 1){
                    startX = j;
                    startY = i;
                }
            }
        }

        visited = new int[list.size()];

        dfs(startY,startX, M, 0);


        
        System.out.println(max);
    }

    public static void dfs(int y, int x, int heart, int count){
        if (distance(y, x, startY, startX) <= heart) {
            max = Math.max(max, count);
        }

        for(int i=0;i<list.size();i++){
            Node node = list.get(i);
            int dist = distance(y,x, node.y,node.x);
            if( dist<= heart){
                if(visited[i] !=1 ){

                    visited[i] = 1;
                    dfs(node.y, node.x, heart - dist + H, count + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static int distance(int y, int x, int disY, int disX){
        int nx = Math.abs(x - disX);
        int ny = Math.abs(y - disY);

        return nx + ny;
    }
}
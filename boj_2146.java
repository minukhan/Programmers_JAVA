import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2146 { // 1:57

    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean[][] visited;
    public static int[][] road ;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int N;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        road = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<N;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N 은 100 이하의 자연수
        // 100 * 100 == 10,000

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                if(road[i][j] == 0) continue;
                list.add(bfs(i,j));
            }
        }

        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<list.size();i++){
            ArrayList<Node> FList = list.get(i);
            for(int j=0;j<list.size();j++){

                if(i==j) continue;
                
                ArrayList<Node> SList = list.get(j);

                min = Math.min(min, distance(FList, SList));
                
            }
        }

        System.out.println(min-1);
        
    }

    public static int distance(ArrayList<Node> FList, ArrayList<Node> SList){
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<FList.size();i++){
            Node FNode = FList.get(i);
            for(int j=0;j<SList.size();j++){
                Node SNode = SList.get(j);
                
                int dx = Math.abs(FNode.x - SNode.x);
                int dy = Math.abs(FNode.y - SNode.y);
                
                min = Math.min(min,dx+dy);
            }
        }
        return min;
    }
    
    
    public static ArrayList<Node> bfs(int y, int x){

        ArrayList<Node> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        list.add(new Node(x,y));
        queue.add(new Node(x,y));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeX = node.x;
            int nodeY = node.y;
            
            for(int i=0;i<dx.length;i++){
                int nx = nodeX+ dx[i];
                int ny = nodeY+ dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                if(visited[ny][nx]) continue;
                if(road[ny][nx] == 0) continue;
                
                queue.add(new Node(nx,ny));
                list.add(new Node(nx,ny));
                visited[ny][nx] = true;
            }
        }

        
        return list;
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class boj_16954 {
    public static int[][] chess;

    static class Node{
        int y;
        int x;
        int count;
        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    // public static ArrayList<Node> list;

    public static int[] dx = {0,0,1,-1, 1, -1, -1,1, 0};
    public static int[] dy = {1,-1,0,0, -1, -1, 1,1, 0};
    public static int[][][] visited;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방문배열 선언
        visited = new int[10][8][8];
        
        // // 벽의 위치를 기록. 
        // list = new ArrayList<>();
        
        // 벽은 1, 빈 공간은 0
        chess = new int[8][8];
        for(int i=0;i<8;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                int index = -1;
                if(input.charAt(j) == '.'){
                    index = 0;
                }
                else{
                    // list.add(new Node(i,j));
                    index = 1;
                }
                chess[i][j] = index;
            }
        }

        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(7,0,0));
        visited[0][7][0] = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- >0){
                
                Node node = queue.poll();

                if(node.y == 0 && node.x == 7){
                    System.out.println(1);
                    return;
                }

                node.count = Math.min(node.count, 8);
    
                for(int i=0;i<9;i++){
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    
                    if(ny < 0 || ny >=8 || nx < 0 || nx >=8) continue;
                    if(visited[node.count + 1][ny][nx] == 1) continue;
                    if(chess[ny][nx] == 1) continue;

                    queue.add(new Node(ny,nx,node.count + 1));
                    visited[node.count + 1][ny][nx] =1;
                }
            }
            move();
            queue = check(queue);
        }

        System.out.println(0);
    }
    
    // 벽을 내렸을 때 큐에 같은게 있는지 체크. 
    public static Queue<Node> check(Queue<Node> queue){

        Queue<Node> newQueue = new LinkedList<>();
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
        
            int x = node.x;
            int y = node.y;

            if(chess[y][x] != 1) newQueue.add(node);
        }

        return newQueue;
    }
    // 벽의 위치 내리기
    public static void move(){
        
        for(int i=7;i>=0;i--){
            for(int j=0;j<8;j++){
                if(i == 7) continue;
                if(i == 0){
                    chess[i+1][j] = chess[i][j];
                    chess[i][j] = 0;
                    continue;
                }
                chess[i+1][j] = chess[i][j];
            }
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


class boj_18450 {
    public static Queue<Node> queue;
    public static int N;
    public static int K;
    public static int[][] visited;

    static class Node{
        int y;
        int x;
        int index;
        public Node(int y, int x, int index){
            this.y= y;
            this.x= x;
            this.index= index;
        }
    }
    public static int S;
    public static Node end;
    public static int[] dx = {0,0, -1,1};
    public static int[] dy = {-1,1,0,0};
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[N][N];
        queue = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input != 0){
                    queue.add(new Node(i,j,input));
                    visited[i][j] = input;
                }
            }
        }
        
        st=  new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        bfs();
        
        System.out.println(visited[end.y-1][end.x-1]);
        
        
    }

    // 1부터 나오도록 하는거
    // 1초가 다같이 한번하면 1초임. 

    public static void bfs(){
        
        //초기값은 위에서 완료.

        while(!queue.isEmpty()){

            int size = queue.size();
            
            if(S == 0){
                return;
            }

            PriorityQueue<Node> newQueue = new PriorityQueue<>(
              (o1, o2) -> Integer.compare(o1.index, o2.index) 
            );

            while(!queue.isEmpty()){
                newQueue.add(queue.poll());
            }
            
            while(size-- > 0){
                
                Node node = newQueue.poll();
    
                for(int i=0;i<4;i++){
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if(visited[ny][nx] != 0) continue;
    
                    visited[ny][nx] = node.index;
                    queue.add(new Node(ny,nx, node.index));
                }
            }
            
            S--;

            
            
        }
    }
}





















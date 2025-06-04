import java.util.*;
import java.lang.*;
import java.io.*;


// 6:43

// N * M 크기의 공간이 있다.
// 아기상어가 최대 1마리 존재한다.
// 대각선까지 이동 가능.
// 안전거리가 가장 큰 칸을 구해보자.
// N, M은 50까지 주어진다.
// BFS로 아기상어의 point 를 기억해놓고 그 list 들을 BFS 돌리면서 가도 되고.
// BFS 를 모든 칸에다가 돌리면 되긴 하겠네. 금방 끝날 것 같긴한데 효율 챙기게 list 로 가보자

class boj_17086 {

    public static int[][] map;
    public static int[][] answer;
    public static int[][] visited;
    public static int N;
    public static int M;
    public static ArrayList<Node> list;

    static class Node{
        int y;
        int x;
        int count;
        public Node(int y,int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static int[] dx = {0,0,-1,1,-1,1,-1,1};
    public static int[] dy = {1,-1,0,0,-1,-1,1,1};
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];
        visited = new int[N][M];
        list = new ArrayList<>();

        for(int arr[] : answer){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    list.add(new Node(i,j,0));
                }
            }
        }

        bfs();
        
        int max = 0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(max < answer[i][j] && answer[i][j] != Integer.MAX_VALUE){
                    max = answer[i][j];
                }
            }
        }


        System.out.println(max);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        for(Node node : list){
            queue.add(node);
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            for(int i=0;i<8;i++){

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] == 1) continue;
                if(node.count + 1 >= answer[ny][nx]) continue;
                
                queue.add(new Node(ny,nx, node.count+1));
                answer[ny][nx] = node.count+1;
            }
        }
    }
}
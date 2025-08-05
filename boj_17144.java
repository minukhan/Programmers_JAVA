import java.util.*;
import java.lang.*;
import java.io.*;

class boj_17144 {
    public static int N;
    public static int M;
    public static int[][] road;
    public static Node first;
    public static Node second;
    public static Queue<Node> queue;
    
    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static int[][] nextRoad;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int T;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         T = Integer.parseInt(st.nextToken());

        road = new int[N][M];
        boolean check = true;
        queue = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
                if(road[i][j] == -1){
                    if(check){
                        first = new Node(i,j);
                        check = false;
                    }
                    else{
                        second = new Node(i,j);
                    }
                }
                else if(road[i][j] != 0){
                    queue.add(new Node(i,j));
                }
            }
        }
        
        bfs();

        System.out.println(answer());
        
    }

    public static void bfs(){

        //변동되는 곳 
        nextRoad = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                nextRoad[i][j] = road[i][j];
            }
        }

        while (T-- > 0) {
            visited = new boolean[N][M];
        
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
        
                int spread = road[node.y][node.x] / 5;
                int count = 0;
        
                if (spread == 0) {
                    continue;
                }
        
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
        
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (road[ny][nx] == -1) continue;
        
                    nextRoad[ny][nx] += spread;
                    count++;
        
                    // 먼지 퍼진 칸은 나중에 퍼질 주체가 아님
                }
        
                nextRoad[node.y][node.x] -= spread * count;
            }
                
            up(first.y, first.x);
            down(second.y, second.x);
        
            // queue 갱신
            queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (nextRoad[i][j] > 0) {
                        queue.add(new Node(i, j));
                    }
                }
            }
        
            // 다음 턴을 위해 현재 상태 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    road[i][j] = nextRoad[i][j];
                }
            }
        }
    }

    public static void up(int y, int x){
        ArrayList<Integer> list = new ArrayList<>();
        
        // 오른쪽 쭉
        for(int i=x+1;i<M-1;i++){
            list.add(nextRoad[y][i]);
        }

        // 아래쪽 쭉
        for(int i=y;i>0;i--){
            list.add(nextRoad[i][M-1]);
        }

        // 왼쪽 쭉
        for(int i=M-1;i>0;i--){
            list.add(nextRoad[0][i]);
        }
        // 위쪽으로 쭉 
        for(int i=0;i<y;i++){
            list.add(nextRoad[i][0]);
        }
        
        //반시계 방향으로 회전
        int result = list.remove(list.size() -1);
        list.add(0, 0);
        int index =0;
        
        // 오른쪽 쭉 
        for(int i=x+1;i<M-1;i++){
            nextRoad[y][i] = list.get(index++);
        }

        // 아래쪽 쭉
        for(int i=y;i>0;i--){
            nextRoad[i][M-1] = list.get(index++);
        }

        // 왼쪽 쭉
        for(int i=M-1;i>0;i--){
            nextRoad[0][i] = list.get(index++);
        }
        // 위쪽으로 쭉 
        for(int i=0;i<y;i++){
            nextRoad[i][0] = list.get(index++);
        }
    }

    public static void down(int y, int x){
        ArrayList<Integer> list = new ArrayList<>();

        // 오른쪽 쭉
        for(int i=x+1;i<M-1;i++){
            list.add(nextRoad[y][i]);
        }

        // 위쪽으로 쭉 
        for(int i=y;i<N-1;i++){
            list.add(nextRoad[i][M-1]);
        }

        // 왼쪽 쭉
        for(int i=M-1;i>0;i--){
            list.add(nextRoad[N-1][i]);
        }
        
        // 아래쪽 쭉
        for(int i=N-1;i>y;i--){
            list.add(nextRoad[i][0]);
        }

        int result = list.remove(list.size()-1);
        list.add(0, 0);
        int index =0;
        
        // 오른쪽 쭉
        for(int i=x+1;i<M-1;i++){
            nextRoad[y][i] = list.get(index++);
        }

        // 위쪽으로 쭉 
        for(int i=y;i<N-1;i++){
            nextRoad[i][M-1] = list.get(index++);
        }

        // 왼쪽 쭉
        for(int i=M-1;i>0;i--){
            nextRoad[N-1][i] = list.get(index++);
        }
        
        // 아래쪽 쭉
        for(int i=N-1;i>y;i--){
            nextRoad[i][0] = list.get(index++);
        }
        
    }

    public static int answer(){
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sum += road[i][j];
            }
        }

        return sum + 2;
    }

    public static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(nextRoad[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}



























import java.util.*;
import java.lang.*;
import java.io.*;

class boj_16234 {
    // 10:20

    static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] visited;
    public static int[][] A;
    public static int N;
    public static int L;
    public static int R;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        //N * N 의 땅이 있음. N은 50
        A = new int[N][N];
        
        // 각 땅에는 나라가 하나씩 존재한다.
        // A 2차원 배열인데 여기에는 인원수가 기록되어있음.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        int answer =0;

        while(true){
          visited = new int[N][N];
            boolean check = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        if (bfs(i, j)) check = true;
                    }
                }
            }

            if (!check) break;
            answer++;
        }
        
        System.out.println(answer);
        
    }


    public static boolean bfs(int startY, int startX){

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();
        
        queue.add(new Point(startX,startY));
        list.add(new Point(startX,startY));
        visited[startY][startX] = 1;
        int sum = A[startY][startX];

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for(int i=0;i<4;i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] != 0) continue;
                if(Math.abs(A[y][x] - A[ny][nx]) < L || Math.abs(A[y][x] - A[ny][nx]) > R) continue;

                queue.add(new Point(nx,ny));
                list.add(new Point(nx,ny));
                sum += A[ny][nx];
                visited[ny][nx] = 1;
            }

        }
        if(list.size() == 1) return false;

        int avg = sum/ list.size();
        for(Point point : list){
            A[point.y][point.x] = avg;
        }
        
        return true;

    }   
}
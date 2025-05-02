import java.util.*;
import java.lang.*;
import java.io.*;


//1 :55
// 눈금의 간격이 1이고 M,N 이 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그리
// 직사각형을 그릴껀데 이때 직사각형으로 나눈 공간의 넓이와 갯수를 세라.
// 100 이하의 자연수들이고 오름차순으로 넓이를 출력해라.
// 2차원 배열 하나 만들어서 for문으로 이용해서 배열을 채워줌 직사각형 안에있는것들 0
// 없는것들 1 해놓고 2차원 for문 이용해서 bfs 돌린다음에 count 세주고 돌렸을때 넓이 
class boj_1583 {

    public static int N;
    public static int answer=0;
    public static int M;
    public static int K;
    public static int[][] map;
    public static int[][] visited;
    public static ArrayList<Integer> list;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for(int i=sy;i<ey;i++){
                for(int j=sx;j<ex;j++){
                    map[i][j] = 1;
                }
            }
        }

        //  for(int i=0;i<N;i++){
        //     for(int j=0;j<M;j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        list = new ArrayList<>();
        int count = 0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    bfs(j,i);
                    count++;
                }
            }
        }

        
        
        list.sort(Comparator.naturalOrder());
            System.out.println(count);
        
        for(int value : list){
            System.out.print(value + " ");
        }
    }


    public static void bfs(int x, int y){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[y][x] = 1;
        answer=1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                int prevX = queue.poll();
                int prevY = queue.poll();
    
                for(int i=0;i<4;i++){
                    int nx = prevX + dx[i];
                    int ny = prevY + dy[i];

                    if(nx < 0 || nx >=M || ny < 0 || ny >=N) continue;
                    if(visited[ny][nx] == 1) continue;
                    if(map[ny][nx] == 1) continue;

                    visited[ny][nx] = 1;
                    map[ny][nx] = 1;
                    queue.add(nx);
                    queue.add(ny);
                    answer++;
                }
                size = size - 2;
            }
            
        }
        
        list.add(answer);
    }
}

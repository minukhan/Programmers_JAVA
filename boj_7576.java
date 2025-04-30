import java.util.*;
import java.lang.*;
import java.io.*;


// 4:50

// 격자모양에 토마토들을 보관
// 잘 익은것도 있는데 아직 익지 않은 토마토도 있음.
// 보관후 하루가 지나면 익어버림 이때 익은 토마토와 인접해있으면 익음. 
// 바이러스 퍼지는느낌으로 퍼짐 이때 창고에 보관된 토마토들이 며칠이 지나야 다 익는지 판단
// 익은 토마토와 익지 않은 토마토가 주어짐. 
// 이게 while 의 횟수로 구분지어서 하는 문제. check 는 그냥 다 돌려보면 될것같고 for문으로
// N 은 1,000 M은 1,000 이므로 메모리 초과 x 
// while 문에 한번 넣어놓고 끝났을때 체크, 아니면 한번 더돌고 또 체크. 이런식으로


class boj_7576 {
    public static int N;
    public static int M;
    public static int answer=0;
    public static int[][] box;
    public static int[] dx = {0,0, -1, 1};
    public static int[] dy = {1,-1, 0 ,0};
    public static ArrayList<Integer> list;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        box = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();
        
        if(check()){
            System.out.println(answer);
            System.exit(0);
        }
        
        bfs();
    }


    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();
        for(int value : list) queue.add(value);

        while(!queue.isEmpty()){
            int size = queue.size()/2;

            while(size > 0){
                int x = queue.poll();
                int y = queue.poll();
    
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
    
                    if(nx < 0 || nx >=M || ny < 0 || ny >=N) continue;
                    if(box[ny][nx] == 1 || box[ny][nx] == -1) continue;
                    
                    box[ny][nx] = 1;
                    queue.add(nx);
                    queue.add(ny);
                }
                size--;
            }
            answer++;

            
            if(check()){
                System.out.println(answer);
                System.exit(0);
            }
        }

        System.out.println(-1);
        System.exit(0);
    }

    public static void init(){
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j] ==1){
                    list.add(j);
                    list.add(i);
                }
            }
        }
    }
    

    public static boolean check(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j] ==0){
                    return false;
                }
            }
        }

        return true;
    }
}

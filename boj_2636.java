import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2636 {

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y= y;
            this.x= x;
        }
    }
    public static int N;
    public static int M;
    public static boolean[][] map;
    public static ArrayList<Node> list;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        // 1 ~ N+1 , 1 ~ M+1 저장될 공간임.
        map = new boolean[N+2][M+2];
        list = new ArrayList<>();
        
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<M+1;j++){

                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input == 1 ? true : false;
            }
        }

        // for(int i=1;i<N+1;i++){
        //     for(int j=1;j<M+1;j++){
        //         System.out.print(map[i][j]+ " ");
        //     }
        //     System.out.println("");
        // }

        int count =0;
        int time = 0;
        
        while(check()){

            // 리스트 초기화
            list.clear();

            // 이전의 치즈 갯수 기억해놓기.
            count = count();

            // 녹는 치즈들 위치 list에 저장하기
            bfs();

            // 리스트에 있는 항목들을 0으로 바꾸기
            change();

            // 시간 증가
            time++;
        }


        System.out.println(time);
        System.out.println(count);
        
    }
    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N+2][M+2];
        
        queue.add(new Node(0,0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
            
                if(ny < 0 || ny >= N+2 || nx < 0 || nx >= M+2) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx]){
                    list.add(new Node(ny,nx));
                    continue;
                }
                
                queue.add(new Node(ny,nx));
                visited[ny][nx] = true;
            
            }
        }
        
    }

    public static void change(){
        for(Node node : list){
            int x = node.x;
            int y = node.y;

            map[y][x] = false;
        }
    }

    // 1이 있으면 true, 없으면 false
    public static boolean check(){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]) return true;
            }
        }
        return false;
    }

    // 마지막에 남아있는 칸의 갯수 출력 함수
    public static int count(){
        int count=0;
        
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]) count++;
            }
        }
        
        return count;
    }
}
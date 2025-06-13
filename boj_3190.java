import java.util.*;
import java.lang.*;
import java.io.*;

// 1:40

// Dummy 라는 도스게임.
// 뱀이 나와서 기어다님
// 사과를 먹으면 뱀이 늘어남.
// 벽 또는 자신의 몸과 부딛히면 끝남.
// N * N 보드 위에서 진행되고 사과가 놓여져있음.
// 시작점은 0,0 길이는 1로 고정. 오른쪽을 바라보고 있다.
// 사과의 위치와 뱀의 이동경로가 주어질 떄 이 게임이 몇초에 끝나는지 계산.

// N < 100 은 : 보드의 크기
// K < 100 : 사과의 갯수
// L < 100 : 뱀의 방향 전환 횟수
// X < 10000 : 시간초 후
// C in ('L', 'D');
// L 이면 왼쪽 D 면 오른쪽
// 몇초후에 끝나는지 판단해라. 
// 덱을 이용하면 뒤에 넣어놨던 거 쉽게 뺄 수 있지 않을까 싶네. queue 에 빼고. visited
// 하나 추가해서 빠르게 판단하기.
class boj_3190 {

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y= y;
            this.x= x;
        }
    }

    static class Direction{
        int time;
        char turn;
        public Direction(int time, char turn){
            this.time= time;
            this.turn= turn;
        }
    }
    public static ArrayList<Direction> list;
    public static int N;
    public static int K;
    public static int L;
    public static int answer;
    public static int[][] map;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
         K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 사과를 map 에 위치시키는 코드.
        StringTokenizer st;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) -1;
            int x = Integer.parseInt(st.nextToken()) -1;

            map[y][x] = 1;
        }

        // 방향 기록하기
         L = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char turn = st.nextToken().charAt(0);

            list.add(new Direction(time, turn));
        }

        answer =0;

        simulation();

        System.out.println(answer);
    }

    public static void simulation(){

        // 1이면 오른쪽, 2면 아래, 3이면 왼쪽, 4면 위쪽
        int direct =1;
        int x =0;
        int y =0;
        // 만약 사과 안먹었다면 앞에서 제거를 해야하니까 Deque 을 사용.
        // 그리고 몸통을 표시하는 방법은 map = 2 면 몸통. 0이면 없는것. 1이면 사과
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        map[0][0] = 2;
        
        while(true){
            
            int nx = x;
            int ny = y;
            
            // list 가 존재한다면
            if(list.size() > 0){
                Direction dir = list.get(0);

                if(dir.time == answer){ // 지난 시간이 같으면
                    if(dir.turn =='D'){ // D면 오른쪽으로 회전
                        direct++;

                        if(direct == 5){
                            direct = 1;
                        }
                    }
                    else{ // 아니면 왼쪽으로 회전.
                        direct--;
                        
                        if(direct == 0){
                            direct = 4;
                        }
                    }
                    list.remove(0);
                }
            }
            
            switch(direct){
                case 1: 
                    nx = x+1;
                    break;
                case 2:
                    ny = y+1;
                    break;
                case 3:
                    nx = x-1;
                    break;
                case 4:
                    ny = y-1;
                    break;
            }

            // 만약 범위 밖으로 넘어갔다면 종료
            if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                answer++;
                return;
            }

            // 나의 몸통이라면
            if(map[ny][nx] == 2){
                answer++;
                
                return;
            }
            
            if(map[ny][nx] == 1){ // 사과가 있다면
                queue.add(new Node(ny,nx));
                map[ny][nx] = 2;
            }
            else{ // 사과가 없다면
                queue.add(new Node(ny,nx));
                Node node = queue.pollFirst();
                map[node.y][node.x] = 0;
                map[ny][nx] = 2;
            }

            x = nx;
            y = ny;

            answer++;
        }
    }
}

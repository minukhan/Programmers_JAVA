import java.util.*;
import java.lang.*;
import java.io.*;


// 7:40

// 수빈이는 동생과 숨바꼭질을 하고있다.
// 현재 N에 있고 동생은 K에 있다. 
// 각각 500,000 까지 가능.
// 걷거나 순간이동이 가능. 수빈이가 X-1, X+1 X*2 3개 가능.
// 동생은 항상 걷기만 하는데 가속이 붙음. 이전에 이동한 거리보다 1만큼 더해서 이동.
// 동생이 뒤로 갈 수 있겠지 그랬을때 가장 빠른 시간이 몇초인지 구해라.
// 동생의 위치는 실시간으로 바뀔테고 딱 시간이 맞아 떨어질때 만나야함. 
// 일단 가장 빠른거니까 BFS 가 맞는거같고 
// queue 를 이용해서 관리를 할때
// 시간 제한이 1/4초니까 2500 만까지 가능. 
// 동생을 먼저 돌리고 hash값에 넣어놓고 
// 음. 2가지가 일치해야하니까 다 검사하기에는 당연히 안되고
// 배열을 써야겠네 근데 메모리 제한이 500MB 이므로 2차원배열은 안됨. -> 5억까지가능

// boolean[500000][100] 이렇게하면 메모리초과 안나지않을까 싶은데. 100초내로 다 찾을 수 있지 않나
// 동생 돌리고 수빈이 돌리고 수빈이 돌렸을때 배열에 저장되어있는값을 판단.
class boj_17071 {

    public static int N;
    public static int kid=0;
    public static int count=0;
    public static int M;
    public static boolean start;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[500001][2];
        start = true;
        bfs();
        
    }


    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N][0] = true;

        while(!queue.isEmpty()){
            // 처음일때는 초기화 하지 않기. 
            if(!start){
                kid = kid + count;
            }
            else{
                kid = M;
                start = false;
            }

            if(kid > 500000){
                System.out.println(-1);
                System.exit(0);
            }

            if (visited[kid][count % 2]) {
                System.out.println(count);
                System.exit(0);
            }
            
            int size = queue.size();
            
            while(size > 0){

                int current = queue.poll();

                if(current == kid){
                    System.out.println(count);
                    System.exit(0);
                }

                // 뒤로가는경우
                // K가 더 크다면 안해됨. 앞으로만 가야하기 때문
                if(current -1 >= 0 &&  !visited[current-1][(count + 1) % 2]){
                    queue.add(current - 1);
                    visited[current -1][(count+1) % 2] = true;
                }
                
                // 앞으로가는경우
                // K가 더 크다면? 따라잡을 수 있어? 
                // 못잡음.
                if(current +1 <= 500000  && !visited[current + 1][(count + 1) % 2]){
                    queue.add(current +1);
                    visited[current +1][(count+1) % 2] = true;
                }
        
                // 순간이동하는경우
                // 언제든 가능. 
                if(current * 2<=500000 && !visited[current * 2][(count + 1) % 2]){
                    queue.add(current*2);
                    visited[current * 2][(count+1) % 2] = true;
                }
                
                size--;
            }

            count++;
        }
    }
    
}

    
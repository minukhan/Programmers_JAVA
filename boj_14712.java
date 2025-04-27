import java.util.*;
import java.lang.*;
import java.io.*;


// 3:46

// 직사각형 모양의 격자판이 있다.
// 격자판의 비어있는 칸을 임의로 골라 네모를 올려놓는다.
// 네모가 올라간 칸 4개가 2*2 사각형을 이루는 부분을 찾아 네모를 모두 없애는 과정 반복
// 적당히 플레이하다가 격자판 위에 없앨 수 있는 네모가 없다면 게임을 그만.
// 네모가 게임을 그만두었을때 네모의 배치의 가짓수를 구해라.
// 최대 25개이므로 25!? 음..
// 일단 뺵트래킹인데 2개로 나뉘는듯. 네모를 두는거랑 네모를 없애는 행위.
// 네모를 없애는 행위를 할때 만약 격자판 위에 없앨 수 있는게 없다면 그만둠.
// 종료 조건을 어떻게 설정할까 흠.. 최대 갯수보다 횟수? 횟수 괜찮은데
// 횟수가 5*5 면 2의 25승이라 되네?? int 가능
// 아니 2*2 이거 없애는걸 고려를 안해도 되네. 그냥 만들때 그거를 생성하지 않도록 하는
// 경우의수를 구하면 되는문제.
// 순서대로 탐색을 이어나가니까 왼쪽 위 , 위, 왼쪽만 고려하면 됨.

class boj_14712 {

    public static int N;
    public static int M;
    public static int answer;
    public static int total;
    public static int[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N][M];

        dfs(0,0);
        
        System.out.println(answer);
        
    }

    public static void dfs(int x, int y){

        if(y == N){
            answer++;
            return;
        }

        int nextX = x+1;
        int nextY = y;

        if(nextX == M){
            nextX = 0;
            nextY = y+1;
        }

        dfs(nextX,nextY); // 놓지 않는 경우

        boolean check = false;

        if(x>0 && y>0){
            if(visited[y-1][x-1] == 1
            && visited[y-1][x]   == 1
            && visited[y][x-1]   == 1){
                check = true;
            }
        }

        if(!check){
            visited[y][x] = 1;
            dfs(nextX,nextY);
            visited[y][x] = 0;
        }
        
    }
}

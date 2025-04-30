import java.util.*;
import java.lang.*;
import java.io.*;

// 10 : 44

// 스타트업 
// 총 F층으로 이루어진 고층 건무렝 사무실이 있다. 
// 스타트링크가 있는 곳은 G층
// 강호가 있는 곳은 S층
// S - > G 로 이동하려고 하는거임 총 F층으로 되어있는 건물을
// 엘리베이터는 버튼이 2개밖에 없다. 
// U 버튼은 U층으로 가는 버튼
// D 버튼은 아래로 D층을 가는 버튼 만약 범위를 벗어나면 움직이지 않음.
// G층에 도착하려면 버튼을 적어도 몇번 눌러야하는지 구해라. 
// G층에 갈수없으면 use the 출력
// 1,000,000 개까지 주어짐. UD 도 1,000,000
// 최악일경우 N이 100만일때 u,d가 1 일때 dfs 돌리면 너무 많아지겠네. BFS는?
// 다 돌면서 최단거리로 찾는거기때문에 BFS가 맞긴하겠네. 근데 못찾을경우는 어떻게 처리?
// visited 처리를 해줘야겠네 엘리베이터에 안그러면 계속 돌테니.

class boj_5014 {

    public static int max;
    public static int now;
    public static int find;
    public static int up;
    public static int down;
    public static int count=0;
    public static int[] visited;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = Integer.parseInt(st.nextToken());
        now = Integer.parseInt(st.nextToken());
        find = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        visited = new int[max+1];

        bfs();

    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(now);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int current = queue.poll();

                if(current == find){
                    System.out.println(count);
                    System.exit(0);
                }
    
                if(current - down > 0 && visited[current - down] != 1){
                    visited[current - down] = 1;
                    queue.add(current - down);
                }
    
                if(current + up <= max && visited[current + up] != 1){
                    visited[current + up] = 1;
                    queue.add(current + up);
                }
                size--;
            }
            count++;
        }

        System.out.println("use the stairs");
    }
}

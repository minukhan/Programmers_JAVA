import java.util.*;
import java.lang.*;
import java.io.*;


// 10: 33

// 차량이 이동 가능한 시나리오의 수
// 0 : 빈칸 , 1 : 벽
// 상하좌우
// 한번 지나간 지점은 다시 방문해선 안됨, 벽은 지나갈 수 없음
// N 은 4 이하. m 은 16 이하.
// DFS를 돌리는데.. 흠 조건이 방문해야하는 위치를 무조껀 방문해야하는데.

// 여기서 방문하는 방법은 수없이 많음. 이때 지나간 곳은 지나가지 못한다는게 포인트 
// 나눠서 DFS 를 돌리는건 말이안됨. 왜나하면 중복이 있기때문
// 그럼 합쳐서 돌려야하는건데, 매개변수로 주어진곳을 배열로하는 것을 만들어서
// 그곳에 위치하면 1로 초기화하고 지점을 다 돌았을떄
// 모두 1이면 count 아니면 return 이런식으로 가면 될듯.

class soft_1 {

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static int N;
    public static int answer=0;
    public static int M;
    public static ArrayList<Node> list;
    public static int[][] map;
    public static int[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[N+1][N+1];
        visited = new int[N+1][N+1];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list.add(new Node(y,x));
        }

        // for(int i=0;i<list.size();i++){
        //     System.out.println( i + " : "  + list.get(i).y);
        //     System.out.println( i + " : "  + list.get(i).x);
        //     System.out.println(list.get(i).y * N + list.get(i).x);
        // }
        
        // System.out.println(list.get(0).y);
        // System.out.println(list.get(0).x);
        
        int[] record = new int[N*N];
        dfs(list.get(0).y , list.get(0).x,  0, record);

        
        System.out.println(answer);
        
    }

    public static boolean check(int[] visit){

        int i=0;
        int j=1;
        
        while(i < visit.length){

            int index = visit[i];
            Node node = list.get(j);

            // System.out.println("index : " + index);
            // System.out.println(node.y * N + node.x);
            
            if(index == node.y * N + node.x){
                i++;
                j++;
            }
            else{
                i++;
            }

            if(j == list.size()){
                return true;
            }
        }

        return false;
    }

    public static void dfs(int y, int x,  int count, int[] record){
        Node node = list.get(M-1);
        visited[y][x] = 1;

        if(x == node.x && y == node.y){
            
            // System.out.println("######");
            // System.out.println("count :" + count);
            // System.out.println("y :" + y);
            // System.out.println("x :" + x);
            
            // for(int i=0;i<record.length;i++){
            //     System.out.println( i + " : "  + record[i]);
            // }

            // for(int j=0;j<list.size();j++){
            //     System.out.print( j + " : ");
            //     System.out.println(list.get(j).y * N + list.get(j).x);
            // }
            
            if(check(record)) answer++;
            return;
        }
        
        if(count == N * N){
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny < 1 || ny > N || nx < 1 || nx > N) continue;
            if(visited[ny][nx] == 1) continue;
            if(map[ny][nx] == 1) continue;

            record[count] = ny * N + nx;
            visited[ny][nx] = 1;
            dfs(ny, nx, count +1, record);
            visited[ny][nx] = 0;
            record[count] = 0;
        }
    }
}
// 4 5 6
// 7 8 9 
// 10 11 12





































import java.util.*;
import java.lang.*;
import java.io.*;


// 1:06
// 티떱숲에 홍수를 일으키려고 한다.
// 이 숲에는 고슴도치가 살고있는데 비버의 굴로 빨리 도망가려함.

// R행 C열로 이루어져있고 비어있mport java.util.*;
import java.lang.*;
import java.io.*;


// 1:06
// 티떱숲에 홍수를 일으키려고 한다.
// 이 숲에는 고슴도치가 살고있는데 비버의 굴로 빨리 도망가려함.

// R행 C열로 이루어져있고 비어있는 곳 : .
// 물이 차있는 지역은 *
// 돌은 X 로 표시되어있다.
// 비버의 굴은 D 
// 고슴도치의 위치는 S로 나타내져 있음. 
// 그니까 S -> D 로 가야겠네. 물도 퍼져나감.
// 지도가 주어졌을때 안전하게 굴로 이동하기위한 최소시간. 
// 물이 찰 예정인 칸으로 이동할 수 없다. 50보다 작거나 같음. 
// 자 일단 BFS가 맞고 최소거리니까 너비우선탐색으로 찾는게 맞음. 
// 물의 위치를 먼저 퍼트리면 되겠지. road를 변환시켜서 실시간으로 바뀌게. 
// 그랬을때 얼마나 걸리는지 알아야되기때문에 size 를 이용해서 문제를 해결하자.
// 딱히 클래스를 만들 필요는 없을듯.

class boj_3055 {
    public static int N;
    public static int M;
    public static int startX;
    public static int endY;
    public static int endX;
    public static int startY;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static char[][] map;
    public static int[][] visited;
    public static ArrayList<Node> list;
    
    static class Node{
        int x;
        int y;
        int count;
        int water;
        public Node(int x, int y, int count, int water){
            this.x = x;
            this.y = y;
            this.count = count;
            this.water = water;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new char[N][M];
        visited = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            for(int j=0;j<M;j++){
                char c = input.charAt(j);

                if(c == 'S'){
                    startX = j;
                    startY = i;
                }
                if(c == 'D'){
                    endX = j;
                    endY = i;
                }
                if(c == '*'){
                    list.add(new Node(j,i,0,1));
                }

                map[i][j] = c;
            }
        }

        bfs();
        
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        for(Node node : list){
            queue.add(node);
            visited[node.y][node.x] = 1;
        }
        
        queue.add(new Node(startX,startY,0,0));
        visited[startY][startX] = 1;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == endX & node.y == endY){
                System.out.println(node.count);
                return;
            }
            
            

            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >=M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] ==1) continue;
                if(map[ny][nx] == 'X') continue;
                if(map[ny][nx] == '*') continue;

                if(node.water == 1){
                    if(map[ny][nx] != 'D' && map[ny][nx] != 'X'){
                        map[ny][nx] = '*';
                        queue.add(new Node(nx,ny,node.count + 1,1));
                        visited[ny][nx] = 1;
                    }
                    continue;
                }

                queue.add(new Node(nx,ny,node.count + 1,node.water));
                visited[ny][nx] = 1;
            }
        }

        System.out.println("KAKTUS");
    }
}

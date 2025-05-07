import java.util.*;
import java.lang.*;
import java.io.*;


// 9:31

// N * N 개의 방이 있는 거대한 헛간을 새로 지었다. 
// N은 100까지 가능하고 최대한 많은 방에 불을 밝히고 싶어함.
// 유일하게 켜져있는 방 0,0
// 불이 켜져있는 방으로만 들어갈 수 있고 어떤 방을 들어가면 스위치가 있다함.
// 이때 켜져있는 방의 갯수를 최대로 해라.
// 한 방에서 여러개가 있을 수 있으므로 동적으로 관리해야함.
// queue 에 넣기만 하면 되는거 아님? 스위치가 있다면 넣고 
// 처음에는 유일하게 켜져있는 방이 0,0 이니까 이전엔 하나도 없는거고 
// 큐에 추가를 해. 그런다음에 반복? 스위치 중복되면 안해도 되는거고.
// 뭐가문제지? 
// 최대 20000 개 이므로 중복처리를 해주긴 해야함.
// 이때 음.. 시간초과?

class boj_11967 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int M;
    public static int answer =0;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] room;
    public static int[][] visited;
    public static ArrayList<Node>[][] list;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][N];
        list = new ArrayList[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                list[i][j] = new ArrayList<>();
            }
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            int nx = Integer.parseInt(st.nextToken()) -1;
            int ny = Integer.parseInt(st.nextToken()) -1;
            list[y][x].add(new Node(nx,ny));
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0));
        visited[0][0] = 1;
        room[0][0] = 1;
        answer++;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            // 방에 들어왔다.
            // 여기서 불을 켜야함.
            for(Node swit : list[node.y][node.x]){
                int switX = swit.x;
                int switY = swit.y;

                if(room[switY][switX] == 1) continue; // 불이 켜져있으면 pass
                if(visited[switY][switX] == 2){
                    queue.add(new Node(switX,switY));
                    visited[switY][switX] = 1;
                }
                room[switY][switX] = 1;
                answer++;
            }
            
            for(int i=0;i<4;i++){

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;// 범위 내여야함
                if(visited[ny][nx] == 1) continue; // 방문했어도 못함
                if(room[ny][nx] == 0){ // 불이 꺼져서 들어갈 수 없는 곳.
                    visited[ny][nx] = 2;
                    continue;
                }

                queue.add(new Node(nx,ny));
                visited[ny][nx] = 1;
                
            }
        }
        
    }
}

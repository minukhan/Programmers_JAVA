import java.util.*;
import java.lang.*;
import java.io.*;


//9:42 

// 빈 공간과 벽으로 이루어진 건물에 갇혀있다. 
// 일부에는 불이났고 출구를 향해 뛰고있음.
// 동서남북 방향으로 불이 퍼져나가고 벽에는 붙지않고
// 인접한 칸으로 이동할 수 있으며 1초가 걸림.
// 범위 체크, 방문체크, 벽인지 체크
// 불이 옮겨진 칸 또는 붙으려는 칸으로도 이동할 수 없다. 
// 테스트 케이스가 100개있을 수 있고
// 가로 세로가 주어지고 1000까지 가능. 
// . 빈공간 # 벽 @ 시작위치 * 
// 탈출은 그냥 인덱스 밖으로 나가면 탈출이네.

class boj_5427 {

    static class Node{
        int x;
        int y;
        int status;
        int time;
        public Node(int x,int y, int status, int time){
            this.x = x;
            this.y = y;
            this.time = time;
            this.status = status; // 1이면 내가 이동하는거 0이면 불
        }
    }
    
    public static int M;
    public static int N;
    public static int[] dx = { 0, 0, -1, 1};
    public static int[] dy = { -1, 1, 0, 0};
    public static Node start;
    public static int[][] building;
    public static int[][] visited;
    public static ArrayList<Node> list;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while(T > 0){

            st = new StringTokenizer(br.readLine());
    
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            building = new int[N][M];
            visited = new int[N][M];
            list = new ArrayList<>();
            
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                for(int j=0;j<M;j++){
                    
                    building[i][j] = change(input.charAt(j));
                    if(input.charAt(j) == '@'){
                        start = new Node(j,i,1,0);
                    }
                    if(input.charAt(j) == '*'){
                        list.add(new Node(j,i,0,0));
                    }
                }
            }

            bfs();

            
            T--;
        }
        
    }
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        
        for(Node node : list){
            queue.add(new Node(node.x,node.y,0,0));
            visited[node.y][node.x] = 1;
        }

        queue.add(start);
        visited[start.y][start.x] = 1;
        boolean check = true;
        
        while(!queue.isEmpty() && check){
            Node node = queue.poll();


            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 불일때
                if(node.status == 0){
                    if(nx < 0 || nx >= M || ny < 0 || ny >=N ) continue;
                }

                //불이 아닐때 인덱스 벗어남 -> 탈출
                if(node.status == 1){
                    if(nx < 0 || nx >= M || ny < 0 || ny >=N ){
                        System.out.println(node.time + 1);
                        check = false;
                        break;
                    }
                }

                if(visited[ny][nx] == 1) continue;
                if(building[ny][nx] == 0) continue;

                visited[ny][nx] = 1;
                queue.add(new Node(nx,ny,node.status, node.time+1));
            }
        }

        if(check){
            System.out.println("IMPOSSIBLE");
        }
    }

    public static int change(char input){
        switch(input){
            case '#':
                return 0;
            case '.':
                return 1;
            case '*':
                return 2;
            case '@':
                return 1;
        }

        return -1;
    }
}
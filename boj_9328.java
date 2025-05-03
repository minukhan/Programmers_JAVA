import java.util.*;
import java.lang.*;
import java.io.*;


// 8:37

// 평면도가 있는데 여기에는 문서의 위치가 모두 나타나있다.
// 빌딩의 문은 모두 잠겨있고 열쇠가 필요
// 일부는 가지고있고 일부는 빌딩 바닥에 놓여져있음
// 상하좌우로만 이동 이때 최대개수

//. : 빈공간을 나타냄
//* : 벽을 나타냄
//$ : 훔쳐야할 문서
// 알파벳 대문자는 문을 나타냄
// 소문자는 열쇠를 나타내며 그 문자의 대문자인 모든문을 열 수 있음.
// 가지고있는 열쇠가 주어지며 없으면 0이 주어짐
// 빌딩 밖에 있다가 가장자리의 벽이 아닌곳을 통해서 빌딩 안팎을 드나들 수 있다.
// 훔칠 수 있는 문서의 최대갯수를 출력
// 높이와 너비가 주어짐. 최대 100까지 가능. 총 그러면 10,000 까지 가능.
// 들어갈 수 있는게 이문제의 키포인트같은데 그러면 들어갈 수 있는곳을 list에 넣어놓고 
// 다 돌리기? 와 너무많은데. 그리고 모든 경우를 고려해야하는거아니야? 이게 최대값이니까
// 다찾아야하자나 뺵트래킹문제인데 문제는 딱봐도 시간초과임. 뭐 열쇠는 배열 하나 만들어서
// 관리한다고 치면 지금 열쇠/문 , 빌딩 밖으로 나갈 수 있음 이렇게 2개네? 그럼 앞은 처리가능
// 뒤가 문제인데 경우가 너무많음. 방문처리를 해도.. 종료조건이 모두 방문했을때..?
// 일단 그러면 빌딩 밖으로 나갈 수 있는곳은 그럼 다 list에 넣어놓고 거기서 들어가게 해?
// 그걸 visited 배열로하나로 관리?  근데 BFS 가 절대적으로 좋나? X 영향이 가네. 보니까
// BFS는 최단거리 가기, 뭐 토마토처럼 익히기 같이 경로를 갈때 뭐 따로 기록해야하는것이
// 없을때 사용하는거네 지금 이거는 열쇠랑 문, 문서갯수 같은걸 기록하려면 visited 배열을
// 하나 더 차원을 만들어서 관리해야함. 보니까 열쇠를 얻었을때 내가 이전에 방문할 수 있는
// 문이 있었다면 그떄 문의 위치를 queue에 추가하면 visited배열을 2차원으로 관리 할 수 있
// 네

class boj_9328 {

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static ArrayList<Node>[] list;
    public static int N;
    public static int M;
    public static char[][] road;
    public static int[][] visited;
    public static int[] key;
    public static ArrayList<Node> wall;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static int count=0;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while(T > 0){
            st = new StringTokenizer(br.readLine());
            count = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            road = new char[N][M];
            visited = new int[N][M];
            key = new int[26]; // 1이면 키가 있는거 아니면 없는거
            list = new ArrayList[26]; // 0이면 A 
            wall = new ArrayList<>();
    
            for(int i=0;i<26;i++){
                list[i] = new ArrayList<>();
            }
            
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                for(int j=0;j<M;j++){
    
                    road[i][j] = input.charAt(j);
                    if(i==0 || i==N-1 || j==0 || j==M-1){
                        if(road[i][j] != '*'){
                            
                            wall.add(new Node(j,i));
                        }
                    }
                }
            }
    
            st = new StringTokenizer(br.readLine());
            String inputKey = st.nextToken();

            if(!inputKey.equals("0")){
                for(int i=0;i<inputKey.length();i++){
                    int findKey = (int)inputKey.charAt(i);
                    key[findKey - 97] = 1;
                }
            }

            bfs();
    
            System.out.println(count);
            
            T--;
        }
    }

    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0;i<wall.size();i++){
            Node start = wall.get(i);

            int find = (int)road[start.y][start.x];

            if (road[start.y][start.x] == '$') {
                count++;
            } else if ('a' <= road[start.y][start.x] && road[start.y][start.x] <= 'z') {
                int index = road[start.y][start.x] - 'a';
                if (key[index] == 0) {
                    key[index] = 1;
                    // 초기 열쇠로 열어야 할 문들 처리
                    for (Node door : list[index]) {
                        visited[door.y][door.x] = 1;
                        queue.add(door);
                    }
                }
            }
                    
            if( find < 91 && find > 64){
                if(key[find-65] == 1){
                    queue.add(new Node(start.x,start.y));
                    visited[start.y][start.x] = 1;
                }
                else{
                    list[find-65].add(new Node(start.x,start.y));
                }

                continue;
            }
            
            queue.add(start);
            visited[start.y][start.x] = 1;
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >=N) continue;
                if(visited[ny][nx] == 1) continue;
                if(road[ny][nx] == '*') continue;

                if(road[ny][nx] == '.'){
                    queue.add(new Node(nx,ny));
                    visited[ny][nx] = 1;
                    continue;
                }
                if(road[ny][nx] == '$'){
                    count++;
                    queue.add(new Node(nx,ny));
                    visited[ny][nx] = 1;
                    continue;
                }
                
                int find = (int) road[ny][nx];
                if(find > 91){ // 소문자 키를 찾았을때
                    // 키가 있다고 표시해두고
                    key[find-97] = 1;
                    // 키를 찾았을 때 문 리스트들이 있으면 모두 queue 에넣기
                    for(Node door : list[find-97]){
                        
                        if(visited[door.y][door.x] == 1) continue;
                        
                        queue.add(door);
                        visited[door.y][door.x] = 1;
                    }
                    
                    queue.add(new Node(nx,ny));
                    visited[ny][nx] = 1;
                    
                }
                else{
                    // 만약 찾은게 문이면 key 가 있는지 확인후 있으면 추가
                    if(key[find-65] == 1){
                        queue.add(new Node(nx,ny));
                        visited[ny][nx] = 1;
                    }
                    else{
                        list[find-65].add(new Node(nx,ny));
                    }
                    // 없으면 list에 저장.
                }
            }
            
        }
    }
}
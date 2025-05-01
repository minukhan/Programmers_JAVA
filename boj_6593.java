import java.util.*;
import java.lang.*;
import java.io.*;


//10:22
// 길이가 1인 정육면체로 이루어져있고
// 지나갈 수 있거나 없음 상하좌우 동서로 이동 할 수있고 출구를 찾아서 탈출
// 3차원 인접행렬 그래프 문제

// L : 층수 
// R : 행수
// C : 열수

// 일단 3차원 배열로 저장을 해놓는게 맞고 거기서 시작점을 찾고 도착점을 찾기
// #은 막혀있다는 표시 비어있으면 . 탈출구는 E 시작지점은 S
// 최단시간이니까 BFS는 맞고 중복체크를 해야하는데 N이 30이니까 27000 이니까 충분
// # -> 0 
// . -> 1

class boj_6593 {

    static class Room{
        int x;
        int y;
        int z;
        int count;
        public Room(int x, int y,int z,int count){
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }

    public static int X;
    public static int Y;
    public static int Z;
    public static Room start;
    public static Room end;
    public static int[][][] map;
    public static int[][][] visited;
    public static int[] dx = { 0, 0, 1, -1, 0, 0};
    public static int[] dy = { 1,-1, 0 ,0, 0 ,0};
    public static int[] dz = {0, 0, 0, 0,  -1, 1};
    public static StringBuilder sb;
    public static boolean check;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Z = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            check = false;
            
            if(Z==0 && Y==0 && X==0){
                System.out.println(sb.toString());
                System.exit(0);
            }
    
            map = new int[Z][Y][X];
            visited = new int[Z][Y][X];
    
            for(int i=0;i<Z;i++){
                for(int j=0;j<Y;j++){
                    st = new StringTokenizer(br.readLine());
                    String row = st.nextToken();
                    for(int k=0;k<X;k++){
                        if(row.charAt(k) == 'S'){
                            start = new Room(k,j,i,0);
                            map[i][j][k] = 2;
                        }
                        if(row.charAt(k) == 'E'){
                            end = new Room(k,j,i,0);
                            map[i][j][k] = 3;
                        }
                        if(row.charAt(k) == '.') map[i][j][k] = 1;
                        if(row.charAt(k) == '#') map[i][j][k] = 0;
                    }
                }
                st = new StringTokenizer(br.readLine());
            }
    
            bfs();
            if(!check){
                sb.append("Trapped!").append("\n");
            }
        }
    }

    public static void bfs(){
        Queue<Room> queue = new LinkedList<>();

        queue.add(start);
        visited[start.z][start.y][start.x] = 1;

        while(!queue.isEmpty()){
            Room room = queue.poll();

            // ending 인지
            if(room.x == end.x && room.y == end.y && room.z == end.z){
                check = true;
                sb.append("Escaped in ").append(room.count).append(" minute(s).").append("\n");
                break;
            }

            for(int i=0;i<6;i++){
                int nx = room.x + dx[i];
                int ny = room.y + dy[i];
                int nz = room.z + dz[i];

                // 인덱스가 유효한지
                if(nx < 0 || nx >= X || nz < 0 || nz >= Z || ny < 0 || ny >= Y ) continue;
                
                // 못가는 길인지
                if(map[nz][ny][nx] == 0) continue;
                
                // 방문했던 곳인지
                if(visited[nz][ny][nx] == 1) continue;

                visited[nz][ny][nx] = 1;
                queue.add(new Room(nx,ny,nz,room.count +1));
            }
        }

    }
}
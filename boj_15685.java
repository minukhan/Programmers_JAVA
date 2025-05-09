import java.util.*;
import java.io.*;

class boj_15685 {

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static int N;
    public static int[][] road;
    public static boolean[][] visited;
    public static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        road = new int[101][101];
        
        visited = new boolean[101][101];
        list = new ArrayList<>();
        
        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int depth = Integer.parseInt(st.nextToken());

            simulation(y, x, direction, depth);
            list.clear();
        }

        System.out.println(count());

    }



    public static void simulation(int y, int x, int direct, int depth){
        list.add(direct);
        visited[y][x] = true;

        while(depth > 0){

            int size = list.size();

            for(int j=size-1; j >= 0 ;j--){
                int newDir = (list.get(j) + 1) % 4;
                list.add(newDir);
            }

            depth--;
        }

        for(int value : list){
            x += dx[value];
            y += dy[value];

            if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                visited[y][x] = true;
            }
        }

    }



    public static int count() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                    count++;
                }
            }
        }

        return count;
    }

}
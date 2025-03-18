import java.util.*;
import java.lang.*;
import java.io.*;

class ColorBlindness {

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int count=1;
    public static int[][] visited;
    public static int N;
    public static char[][] input;
    
    public static void ColorBlindness(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        input = new char[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            char[] RGB = st.nextToken().toCharArray();
            
            for(int j=0;j<N;j++){
                input[i][j] = RGB[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        
        boolean check = false;

        for(int k=0;k<2;k++){
            
            visited = new int[N][N];

            for(int[] row : visited){
                Arrays.fill(row, -1);
            }
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visited[i][j] == -1){
                        bfs(j,i,check);
                        count++;
                    }
                }
            }
            sb.append(count-1).append(" ");
            count =1;
            check = true;
        }
        
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y, boolean check){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        visited[y][x] = count;

        while(!queue.isEmpty()){
            int X = queue.poll();
            int Y = queue.poll();
        
            for(int i=0;i<4;i++){

                int nx = X + dx[i];
                int ny = Y + dy[i];

                if(nx < 0 || nx > N-1) continue;
                if(ny < 0 || ny > N-1) continue;
                if(visited[ny][nx] != -1) continue;

                if(!check){
                    if(input[y][x] != input[ny][nx]) continue;

                    
                }
                else{
                    char color = input[y][x];

                    switch(color){
                        case 'R':
                            if(input[ny][nx] == 'B') continue;
                            break;
                        case 'B':
                            if(input[ny][nx] == 'R' || input[ny][nx] == 'G' ) continue;
                            break;
                        case 'G':
                            if(input[ny][nx] == 'B') continue;
                            break;
                    }
                }
                
                queue.add(nx);
                queue.add(ny);
                visited[ny][nx] = count;
                
            }
        }
    }
}
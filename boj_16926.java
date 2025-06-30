import java.util.*;
import java.lang.*;
import java.io.*;

class boj_16926 {

    public static int N;
    public static int R;
    public static int M;
    public static int[][] map;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Math.min(N, M) / 2;

        for(int i=0;i<T;i++){
            change(i);
        }

        answer();
        
    }
    public static void change(int index){
        ArrayList<Integer> list = new ArrayList<>();
        
        int y = index;
        int x = index;

        while(x < M - index){
            list.add(map[y][x]);
            x++;
            if(x == M - index){
                x--;
                y++;
                break;
            }
        }
        
        while(y < N - index){
            list.add(map[y][x]);
            y++;
            if(y == N - index){
                y--;
                x--;
                break;
            }
        }

        
        while(x >= index){
            list.add(map[y][x]);
            x--;
            if(x == index-1){
                x++;
                y--;
                break;
            }
        }

        while(y >= index){
            if(x == index && y == index){
                break;
            }
            list.add(map[y][x]);
            y--;
        }

        int len =  list.size();
        int move = R % len;


        
         y = index;
         x = index;
        int i=0;
        
        while(x < M - index){
            map[y][x] = list.get((i+move) % len);
            i++;
            x++;
            if(x == M - index){
                x--;
                y++;
                break;
            }
        }
        
        while(y < N - index){
            map[y][x] = list.get((i+move) % len);
            i++;
            y++;
            if(y == N - index){
                y--;
                x--;
                break;
            }
        }

        
        while(x >= index){
            map[y][x] = list.get((i+move) % len);
            i++;
            x--;
            if(x == index-1){
                x++;
                y--;
                break;
            }
        }

        while(y >= index){
            if(x == index && y == index){
                break;
            }
            map[y][x] = list.get((i+move) % len);
            i++;
            y--;
        }
    }

    public static void answer(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}
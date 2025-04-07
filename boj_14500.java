import java.util.*;
import java.lang.*;
import java.io.*;

class boj_14500 { //

    public static int[][][] dxdy = {
            // 으
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},
            // 네모
            {{0,0},{0,1},{1,0},{1,1}},
            // 기역
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{1,0},{2,0},{2,-1}},
            {{0,0},{1,0},{2,0},{0,1}},
            {{0,0},{1,0},{2,0},{0,-1}},
            {{0,0},{1,0},{0,1},{0,2}},
            {{0,0},{1,2},{0,1},{0,2}},
            {{0,0},{-1,0},{0,1},{0,2}},
            {{0,0},{-1,2},{0,1},{0,2}},
            // ??
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,0},{1,0},{1,-1},{2,-1}},
            {{0,0},{0,1},{1,1}, {1,2}},
            {{0,0},{0,1},{-1,1},{-1,2}},
            // 오
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,0},{0,1},{0,2},{-1,1}},
            {{0,0},{1,0},{2,0},{1,1}},
            {{0,0},{1,0},{2,0},{1,-1}}
    };

    public static int[][] road;
    public static int max;
    public static int N;
    public static int M;
    
    public static void main(String[] args) throws IOException {

        // 250,000 * 19 == 가능
        // 일자  : 2개
        // 네모 : 1개
        // 니은 : 8개
        // ? : 4개
        // ㅗ : 4개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

       road = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                count(j,i);
            }
        }
        System.out.println(max);
    }

    public static void count(int x, int y){

        for(int i=0;i<dxdy.length;i++){

            int sum =0;
            boolean no = false;
            
            for(int j=0;j<dxdy[0].length;j++){

                int nx = x + dxdy[i][j][0];
                int ny = y + dxdy[i][j][1];

                if(nx < 0 || nx > M-1 || ny < 0 || ny > N-1){
                    no = true;
                    continue;
                }
                sum += road[ny][nx];
            }

            if(no) continue;
            max = Math.max(max, sum);
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class boj_16927 {

    public static int check;
    public static int N;
    public static int M;
    public static int R;
    public static int[][] arr;
    public static int[][] answer;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        answer = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 함수를 하나 만든다. 
        int max = Math.min(N,M) / 2;
        int index =0;
        
        while(index < max){
            move(index);
            index++;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println("");
        }
        
    }


    public static void move(int count){


        // answer 배열에다가 갱신하기
        
        // 주기를 구한다.
        int cycle = (M - count * 2) * 2 + (N - count* 2) * 2 - 4;
        // R 을 주기로 나눈 나머지를 구한다.
        int div = R % cycle;
        int start = cycle - div;

        if(start == cycle){
            start = 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int y = count;
        int x = count;
        int[][] loop = {{1,0} , {0,1} , {-1,0} , {0, -1}};
        int k=0;
        boolean init = false;

        // list 구하기.
        while(true){
            
            if(x == count && y == count && init){
                break;
            }
            
            list.add(arr[y][x]);
            init = true;
            
            int ny = loop[k][0] + y;
            int nx = loop[k][1] + x;
            
            if(ny < count || nx < count || ny >= N-count || nx >= M-count){
                k++;

                if(k >= 4){
                    break;
                }
                else{
                    y = loop[k][0] + y;
                    x = loop[k][1] + x;
                }
            }
            else{
                y = ny;
                x = nx;
            }
        }
        
         k=0;
         init = false;
         y = count;
         x = count;
        
        while(true){
            
            if(x == count && y == count && init){
                break;
            }

            
            answer[y][x] = list.get(start);
            init = true;
            start = (start + 1) % (cycle);
            
            int ny = loop[k][0] + y;
            int nx = loop[k][1] + x;
            
            if(ny < count || nx < count || ny >= N-count || nx >= M-count){
                k++;

                if(k >= 4){
                    break;
                }
                else{
                    y = loop[k][0] + y;
                    x = loop[k][1] + x;
                }
            }
            else{
                y = ny;
                x = nx;
            }
        }

    }
}
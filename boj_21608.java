import java.util.*;
import java.lang.*;
import java.io.*;

class boj_21608 {

    public static int[][] seat;
    public static int N;
    public static ArrayList<Integer>[] list;
    public static ArrayList<Integer> turn;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        list = new ArrayList[N*N + 1];
        for(int i=0;i<N*N+1;i++){
            list[i] = new ArrayList<>();
        }
        turn = new ArrayList<>();

        for(int i=0;i<N*N;i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            turn.add(index);
            for(int j=0;j<4;j++){
                int like = Integer.parseInt(st.nextToken());

                list[index].add(like);
            }
        }


        seat = new int[N][N];

        for(int k=0;k<N*N;k++){
            int index = turn.get(k);
            simulation(index);
        }

        int answer =0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                switch(find(i,j, seat[i][j])){
                    case 0:
                        break;
                    case 1:
                        answer++;
                        break;
                    case 2:
                        answer = answer + 10;
                        break;
                    case 3:
                        answer = answer + 100;
                        break;
                    case 4:
                        answer = answer + 1000;
                        break;
                }
            }
        }
        System.out.println(answer);
    }

    public static int find(int y, int x, int current){
        int count =0;
        
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            
            if(list[current].contains(seat[ny][nx])) count++;
        }

        return count;
    }
    
    public static int findBlank(int y, int x){
        int count =0;
        
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            
            if(seat[ny][nx] == 0) count++;
        }

        return count;
    }
    
    public static void simulation(int index){

        int blank = 0;
        int like = 0;

        int maxBlank = Integer.MIN_VALUE;
        int maxLike = Integer.MIN_VALUE;

        int indexY = -1;
        int indexX = -1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                
                if(seat[i][j] != 0) continue;
                
                blank = findBlank(i,j);
                like = find(i,j, index);
                // 좋아하는 학생수가 더 많으면 
                if(like > maxLike){
                    indexY = i;
                    indexX = j;
                    maxBlank = blank;
                    maxLike = like;
                }
                else if(like == maxLike){// 좋아하는 학생 수가 같으면 빈칸 갯수로 판단.
                    if(blank > maxBlank){
                        indexY = i;
                        indexX = j;
                        maxBlank = blank;
                        maxLike = like;
                    }
                }
            }
        }
        seat[indexY][indexX] = index;
    }
}
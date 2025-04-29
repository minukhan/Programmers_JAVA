import java.util.*;
import java.lang.*;
import java.io.*;

// 10:42
// 정사각형 모양을 한 다섯종류의 색종이가 있다. 
// 1*1 ~ 5*5 종류로 5개가있음.
// 총 10*10 인 종이 위에 붙이려고 함. 
// 각각의 칸에는 0 or 1 이 적혀져있다. 1이 적힌칸은 모두 색종이로 덮어야함.
// 색종이를 붙일때는 종이의 경계 밖으로 나가면 안되고 겹쳐져도 안된다.  
// 0이 적혀져 있는 칸은 색종이가 있으면 안됨. 
// 종이가 주어졌을때 1이 적힌 모든칸을 붙이는데 필요한 색종이의 갯수.
// 큰거부터 붙이는게 나을듯. 작은것도 해야하네. 
// 5 의 100승..? 완탐이나 뺵트래킹을 해도 무조껀 시간초과일듯. 효율적인 방법을 찾아야함
// 큰거부터 시작했을때 처음으로 나오는게 최소갯수네 보니까 System.exit(0) 하면 되는거
// 아닌가? 낫배드. 근데 못찾은경우..? 다 돌면 당연히 시간초과. 
// 종이는 총 5개까지밖에없음. 그럼 25개가 끝이네
// 큰거부터 채워야하는데 

class boj_17136 {

    public static int[][] map;
    public static int[] paper;
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        boolean[][] one = new boolean[10][10];
        paper = new int[5];
        Arrays.fill(paper, 5);
        
        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    one[i][j] = true;
                }
            }
        }

        // for(int i=0;i<10;i++){
        //     for(int j=0;j<10;j++){
        //         System.out.print(one[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        
        
        dfs(0,0,0);
        
        System.out.println(min==Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int count,int x, int y){
        if (count >= min) return;
        
        if(y == 10){
            min = Math.min(min, count);
            return;
        }
        
        int nx = x + 1;
        int ny = y;
        
        if(nx == 10){
            nx = 0;
            ny = y+1;
        }

        if(map[y][x] == 0){
            dfs(count, nx,ny);
            return;
        }
        

        for(int i=5;i>0;i--){
            if(paper[i-1] <= 0) continue;
            if(!check(x,y,i)) continue;

            paper[i-1]--;
            change(x,y,i,0);
            dfs(count +1, nx,ny);
            change(x,y,i,1);
            paper[i-1]++;
        }
    
    
    }
    public static boolean check(int x, int y, int index){

        if((x + index - 1) > 9 || (y + index - 1) > 9) return false;
        for(int i = y; i < y + index; i++){
            for(int j = x; j < x + index; j++){
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public static void change(int x, int y, int index, int result){

        for(int i = y; i < y + index; i++){
            for(int j = x; j < x + index; j++){
                map[i][j] = result;
            }
        }
    }
}
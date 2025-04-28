import java.util.*;
import java.lang.*;
import java.io.*;


// 9:34
// 스도쿠 가로 세로 각각 9개씩 총 81칸으로 이루어져있음.
// 게임 시작 전에는 1~9까지의 숫자가 적혀져있음 나머지 비난을 채우는 방법이있음.
// 각각의 가로줄과 세로줄에는 1~9, 3*3 안에 박스도 없어야함.
// 주어진 규칙에 맞춰서 검사를 해야함 또 다 만들고하는게 아니라 검사를 미리 하고
// 넣는 방법으로 효율을 챙김. // 다 찾았으면 바로 시스템 종료하고 출력하는걸로
// 3*3 을 어떻게 찾을까인데 구역을 나눠두는게 좋을 것 같은데 이건 따로 함수로 뺴고
// 가로 세로도 따로 빼서 검사하는 함수를 만들어야겠네 아 시간초과 안나나.. 일단 ㄱ

class boj_2580 {

    public static int[][] map;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(-1,0);
    }

    public static void dfs(int x, int y){
        
        int nx=  x+1;
        int ny = y;

        if(nx>=9){
            nx = 0;
            ny = y+1;
        }

        if(ny == 9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println("");
            }
            System.exit(0);
        }

        if(map[ny][nx] != 0){
            dfs(nx,ny);
            return;
        }

        for(int i=1;i<=9;i++){

            if(check(nx,ny,i)){
                map[ny][nx] = i;
                dfs(nx,ny);
                map[ny][nx] = 0;
            }
        }
    }

    public static boolean check(int x, int y, int num){
        int dx = x / 3;
        int dy = y / 3;
        boolean check = true;

        for(int i=0 + dy*3;i<3+dy*3;i++){
            for(int j=0 + dx* 3;j<3 + dx * 3;j++){
                if(map[i][j] == num){
                    return false;
                }                     
            }
        }
        for(int i=0;i<9;i++){
            if(map[i][x] == num) return false;
            if(map[y][i] == num) return false;
        }
        
        return true;
    }
    
}
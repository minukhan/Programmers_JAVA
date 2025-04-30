import java.util.*;
import java.lang.*;
import java.io.*;

// 11:04 24분
// 11명을 미리 골라놨지만 어디 포지션에 배치해야할지 결정하지 못했음.
// 각각의 포지션에서의 능력을 0부터 100까지 정수로 수치화했음. 
// 0은 그 선수가 포지션에 들어갈 수 없다는 뜻.
// 모든 선수의 포지션을 정하는 프로그램을 만들어라.
// 모든 선수를 채웠을때 능력치의 합이 최대값을 출력해라.
// N은 11이고 11개가 들어갈 수 있지만 가지치기가 0도있고, 처리해줄게 많기때문에 뺵트래킹
// 1차원으로 관리해도 될듯? 능력들을 가지고있다가 다찼으면 sum
class boj_3980 {

    public static int[] score;
    public static int[] visited;
    public static int[][] map;
    public static int sum =0;
    public static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N >0){
            StringTokenizer st;
            map = new int[11][11];
            score = new int[11];
            visited = new int[11];
             max = Integer.MIN_VALUE;
            
            for(int i=0;i<11;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<11;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dfs(0);
            
            System.out.println(max);
            N--;
        }
    }
    // 중복을 허용하지 않는 순열?
    public static void dfs(int count){
        if(count == 11 && check()){
            sum = 0;
            for(int i=0;i<11;i++) sum += score[i];
            max = Math.max(max,sum);
            return;
        }

        for(int i=0;i<11;i++){

            if(visited[i] == 1) continue;
            if(map[count][i] == 0) continue;

            visited[i] = 1;
            score[i] = map[count][i];
            dfs(count +1);
            score[i] = 0;
            visited[i] = 0;
        }
    }

    public static boolean check(){

        for(int i=0;i<11;i++){
            if(score[i] == 0) return false;
        }

        return true;
    }

}
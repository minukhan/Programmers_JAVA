import java.util.*;
import java.lang.*;
import java.io.*;

class boj_17281 {  // 12:35

    public static int[] visited;
    public static int max;
    public static int[][] member;
    public static int[] base;
    public static int answer; 
    public static int out;
    public static int N;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        member = new int[N][9];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<9;j++){
                member[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        answer =0;
        visited = new int[9];
        max = Integer.MIN_VALUE;
        base = new int[4];
        dfs("");
        
        System.out.println(answer);
        
    }
    
    public static void score(String order){

        int[] orderMem = new int[9];
        for(int i=0;i<order.length();i++){
            orderMem[i] = order.charAt(i)-'0';
        }
    
        int j = 0;
        int i = 0;
        out = 0;
        base = new int[4];
        int totalScore = 0; 
        
        while(i < N){
            int result = member[i][orderMem[j]];
            totalScore += cal(result);
        
            j++;
            if(out == 3){
                i++;
                out = 0;
                base = new int[4];
            }
        
            j = j % 9;
        }
        
        answer = Math.max(answer, totalScore); 
    }


    public static int cal(int size){
        int score = 0;
    
        switch(size){
            case 0:
                out++;
                break;
            case 1:
                score += base[3];
                base[3] = base[2];
                base[2] = base[1];
                base[1] = 1;
                break;
            case 2:
                score += base[2] + base[3];
                base[3] = base[1];
                base[2] = 1;
                base[1] = 0;
                break;
            case 3:
                score += base[1] + base[2] + base[3];
                base[3] = 1;
                base[2] = 0;
                base[1] = 0;
                break;
            case 4:
                score += base[1] + base[2] + base[3] + 1;
                base[1] = base[2] = base[3] = 0;
                break;
        }
    
        return score;
    }

    public static void dfs(String order){
        if(order.length() == 9){
            score(order);
            return;
        }
    
        if(order.length() == 3){
            if(visited[0] == 0) {
                visited[0] = 1;
                dfs(order + "0");
                visited[0] = 0;
            }
            return;
        }
    
        for(int i=1;i<9;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            dfs(order + i);
            visited[i] = 0;
        }
    }
}
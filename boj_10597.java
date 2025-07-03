import java.util.*;
import java.lang.*;
import java.io.*;

class boj_10597 {

    public static StringBuilder sb;
    public static int[] visited;
    public static int N;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
         N=0;
         sb = new StringBuilder();

        if(input.length() < 10){
            N = input.length();
        }
        else{
            // 10 넘어가는 숫자의 갯수
            int len = (input.length() - 9) / 2; 

            N = 9 + len;
        }

        visited = new int[N+1];

        dfs(input, "");
    }
    public static void dfs(String remain, String answer){

        if(remain.length() == 0){
            System.out.println(answer);
            System.exit(0);
        }

        sb.setLength(0);
        
        // 1자리일때
        sb.append(remain.charAt(0));
        int index = Integer.parseInt(sb.toString());
        if(index > N) return;
        
        if(visited[index] != 1){
            String next = remain.substring(1,remain.length());
            visited[index] = 1;
            dfs(next, answer+ index + " ");
            visited[index] = 0;
        }
        
        sb.setLength(0);
        // 2자리일때
        if(remain.length() <= 1) return;
        sb.append(remain.charAt(0)).append(remain.charAt(1));
        index = Integer.parseInt(sb.toString());

        if(index > N) return;
        if(visited[index] != 1){
            String next = remain.substring(2,remain.length());
            visited[index] = 1;
            dfs(next, answer+ index + " ");
            visited[index] = 0;
        }
        
    }
}
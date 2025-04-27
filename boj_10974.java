import java.util.*;
import java.lang.*;
import java.io.*;

// 5:19
// 모든 순열
// N이 주어졌을때 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력.

class boj_10974 {

    public static int N;
    public static int[] num;
    public static int[] visited;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        sb = new StringBuilder();
        visited = new int[N+1];
        
        dfs(0);
        
        System.out.println(sb.toString());
    }


    public static void dfs(int count){

        if(count == N){
            for(int i=0;i<N;i++) sb.append(num[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){

            if(visited[i] == 1) continue;

            visited[i] = 1;
            num[count] = i;
            dfs(count +1);
            visited[i] = 0;
        }
    }
}
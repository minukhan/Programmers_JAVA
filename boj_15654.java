import java.util.*;
import java.lang.*;
import java.io.*;

class boj_15654 {// 8:08
    // 자연수 N과 M 이 주어졌을때 
    // N개의 자연수중에서 M개를 고르는 수열 8보다 작으므로 최악 8! 완탐 문제없음.
    // 사전순이므로 정렬이 필요해보임. 조합이므로 index를 가지고 문제풀기.
    // 순서를 고려하며 선택함.

    public static int N;
    public static int M;
    public static int[] number;
    public static int[] record;
    public static int[] visited;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];
        record = new int[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        Arrays.sort(number);

        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth){

        if(depth == M){
            for(int i=0;i<M;i++) sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){

            if(visited[i] == 1) continue;

            record[depth] = number[i];
            visited[i] = 1;
            dfs(depth + 1);
            visited[i] = 0;
        }
    }
}
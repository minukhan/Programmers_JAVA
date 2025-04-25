import java.util.*;
import java.lang.*;
import java.io.*;
// 11:04

class boj_15656 {

    // N개의 자연수와 자연수 M이 주어진다. 
    // N개의 자연수는 모두 다른수이고 N개의 자연수중에서 M개를 고른 수열을 출력
    // 7보다 작으므로 최악은 7! 시간초과 안남.
    // 순열인데 중복을 허용하는 순열문제. 완전탐색을 하는데 visited 배열을 이용하기
    
    public static int N;
    public static int M;
    public static int[] num;
    public static int[] record;
    public static int[] visited;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        record = new int[N];
        visited = new int[N];
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int count){

        if(count == M){
            for(int i=0;i<M;i++) sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){

            record[count] = num[i];
            visited[i] = 1;
            dfs(count + 1);
            visited[i] = 0;
        }
    }

}
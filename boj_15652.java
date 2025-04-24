import java.util.*;
import java.lang.*;
import java.io.*;

class boj_15652 {
    // 7:38

    // 자연수 N,M 이 주어졌을때 길이가 M 인 수열을 구하라
    // 같은수를 여러번 골라도 된다. 중복이 가능. 흠 그냥 다 완탐으로 돌리면 되는 문제인가?
    // 근데 오름차순이여야 하니까 max를 인덱스에 하나 두어서 처리하면 될듯? for문도?
    // 고른수열은 오름차순이여야한다. 

    public static int N;
    public static int M;
    public static StringBuilder sb;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        
        dfs(1,0);
        
        System.out.println(sb.toString());
    }

    public static void dfs(int maxIndex, int depth){

        if(depth == M){
            for(int i=0;i<M;i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=maxIndex;i<=N;i++){

            arr[depth] = i; 
            dfs(i, depth + 1);
        }
    }
}
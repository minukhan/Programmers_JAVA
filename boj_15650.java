import java.util.*;
import java.lang.*;
import java.io.*;

class boj_15650 { // 6: 48

    // 자연수 N 과 M 이 주어졌을때 조건을 만족하는 길이가 M 인 수열을 구해라.
    // 중복없이 M 개를 고른 수열. 순서대로 고를지 말지 dfs 돌리면 될듯? index 둬서 조합이
    // 고른 수열은 오름차순이여야한다. 
    // N,M 은 최대 8 이므로 최악 8! 시간이 1초이므로 완탐 가능.
    public static StringBuilder sb;
    public static int N;
    public static int M;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(1,"");
        
        System.out.println(sb.toString());
    }

    public static void dfs(int index, String number){

        if(number.length() == M*2){
            sb.append(number).append("\n");
            
            return;
        }

        if(index > N) return;

        dfs(index + 1, number + index + " ");
        dfs(index + 1, number);
    }
}
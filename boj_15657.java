import java.util.*;
import java.lang.*;
import java.io.*;

// 11:18
class boj_15657 {

    //N개의 자연수와 자연수 M이 주어졌을때 아래 조건.
    // 같은수를 여러번 골라도 된다. 고른수열은 오름차순이여야한다. 
    // N과 M은 8이므로 최악은 8! 시간초과 안나고.
    // 보니까 조합이랑 순열의 차이는 오름차순 조건이 있냐 없냐로 나뉘네
    // 오름차순 조건이 있으면 조합. 없으면 순열. 이건 있으니까 조합. 중복 허용이므로
    // index 그대로 넘겨주면 될듯.
    
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

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int index, int count){
        if(count == M){
            for(int i=0;i<M;i++) sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=index;i<N;i++){

            record[count] = num[i];
            dfs(i, count+1);
        }
    }
}
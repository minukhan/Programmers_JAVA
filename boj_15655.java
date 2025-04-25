import java.util.*;
import java.lang.*;
import java.io.*;


// 10 : 38

class boj_15655 {

    //N개의 자연수와 자연수 M이 주어졌을때 길이가 M인 수열을 모두 구해라.
    // N 개의 자연수는 모두 다른수
    // 고른수열은 오름차순
    // N과 M은 8보다 작거나 같다. 보니까 조합임. 조합인데 중복을 허용하지 않는 조합.
    // 중복을 허용하지 않으니까 index +1 를 시작으로 for문을 돌면 될듯.
    // 입력으로 주어지는 수는 10,000보다 작다.

    public static int N;
    public static int M;
    public static int[] num;
    public static int[] record;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        record = new int[N];
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int index, int depth){
        if(depth == M){
            for(int i=0;i<M;i++) sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=index;i<N;i++){

            record[depth] = num[i];
            dfs(i + 1, depth +1);
        }
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class boj_6603 {
    // 10:31
    // 독일 로또 1~49까지의 숫자중 6개를 고른다.
    // 부분수열을 구하는데 k개를 고른대 거기서 S를 만든다음 그 수만 가지고 번호를 선택
    // k는 갯수고 S는 집합이다. 여기 집합에서 6개의 수를 고르는 경우를 출력.
    // 이떄 집합이므로 중복은 허용 X 조합을 사용. index +1 로 구현하면 될듯.
    // K는 13보다 작으므로 최대 12! 이면 시간초과긴한데 빽트래킹으로 조건이 6개면
    // 종료하므로 시간초과는 안날듯. 

    public static int N;
    public static int[] S;
    public static int[] record;
    public static StringBuilder sb;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            
            if(N==0) break;
            S = new int[N];
            record = new int[6];
            sb = new StringBuilder();
            
            for(int i=0;i<N;i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0,0);
            
            System.out.println(sb.toString());
        }
        

    }

    public static void dfs(int index, int depth){

        if(depth == 6){
            for(int i=0;i<6;i++) sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=index;i<N;i++){

            record[depth] = S[i];
            dfs(i + 1, depth+1);
        }
    }
}
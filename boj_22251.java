import java.util.*;
import java.lang.*;
import java.io.*;

class boj_22251 {
    
    public static int[][] changeCost = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };

    public static int K;
    public static int P;
    public static int N;
    public static int count=0;
    public static int[] number;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 총 층의 수
        K = Integer.parseInt(st.nextToken()); // 자릿수
        P = Integer.parseInt(st.nextToken()); // 최대 반전시킬 수 있는 갯수
        int X = Integer.parseInt(st.nextToken()); // 실제 층

        number = new int[K];
        String parsing ="";
        
        for(int i=K-1;i>=0;i--){
            int di = X % 10;
            X = X / 10;
            parsing = di + parsing;
        }

        for(int i=0;i<number.length;i++){
            number[i] = parsing.charAt(i) - '0';
        }

        dfs(0,1,0);
        
        System.out.println(count-1);
    }
    public static void dfs(int changeCount, int len, int floor){

        if(len==K+1){

            if(changeCount > P) return;
            if(floor > N) return;
            if(floor < 1) return;
            
            count++;
            return;
        }

        for(int i=0;i<=9;i++){
            
            int modifyCount = changeCost[number[len-1]][i];
            
            dfs(changeCount + modifyCount,len + 1,floor * 10 + i);
        }
    }
}
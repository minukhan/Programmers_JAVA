import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1107 {

    public static int N;
    public static int M;
    public static int[] broken;
    public static int len;
    public static int best;
    
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 구해야하는 수 
         N = Integer.parseInt(input);

        // 고장난 버튼의 갯수
         M = Integer.parseInt(br.readLine());

        // 고장난 버튼 처리 0~ 9 까지의 인덱스. 값이 1이면 사용 불가능.
        broken = new int[10]; 

        // 제외된버튼 1로 변환

        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int index = Integer.parseInt(st.nextToken());
                broken[index] = 1;
            }
        }
        best = Math.abs(100 - N);

        dfs(0,"");
        
        System.out.println(best);
        
    }

    public static void dfs(int count, String number){
        // 같은 자리수라면 차이가 적은지 확인하고 찾아냄.

        if (count > 0) {
            int presses = count + Math.abs(Integer.parseInt(number) - N);
            best = Math.min(best, presses);
        }
        if(count == 6) return;

        for(int i=0;i<10;i++){
            // 만약 부서졌다면 넘어가기
            if(broken[i] == 1) continue;

            dfs(count + 1, number + i);
        }
    }
}


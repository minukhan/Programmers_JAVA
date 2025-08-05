import java.util.*;
import java.lang.*;
import java.io.*;

// 태상이의 훈련소 생활
// 가스 조절기를 잃어버림
// 연병장의 흙을 옮기는 일을 수행해야함.
// a 번부터 b 번 칸까지 높이 k만큼 흙을 덮거나 파내라고 지시한다. 
// 흙은 주변 산에서 얼마든 지 구할 수 있음. 
// 모두 지시를 수행해라.

// 시간복잡도 
// N 은 10만개, M 은 10만개. 일반적으로 탐색하면 시간초과
// K만큼 늘어나도록 한다. K * M 하면 1억이기때문에 int 사용가능

class boj_19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] current = new int[N];
        int[] dp = new int[N+1];
        int[] index = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            current[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken()) -1;
            int second = Integer.parseInt(st.nextToken()) -1;
            int K = Integer.parseInt(st.nextToken());
        
            index[first] += K;
            index[second + 1] -= K;
        }

        for(int i=0;i<N;i++){
            index[i+1] += index[i]; 
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            
            int result = current[i] + index[i];
            sb.append(result + " ");
        }

        System.out.println(sb.toString());
        
   
    }
}
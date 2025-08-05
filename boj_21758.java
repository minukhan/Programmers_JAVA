
import java.util.*;
import java.lang.*;
import java.io.*;

// 3:14

// 좌우로 N 개의 장소가 있다. 
// 서로 다른 두 곳을 골라서 벌을 한마리씩 둔다. 
// 또 다른 한 장소를 골라서 벌통을 둔다. 
// 3개는 중복될 수 없는듯. 
// 벌은 똑바로 날아가면서 꿀을 딴다. 
// 각 장소에 적힌 숫자는 지나가면서 딸 수 있는 양
// 두마리가 모두 지나간 장소에서는 두마리 ㅍ표시된 양만큼 꿀을 딴다. 
// 벌이 시작한 장소는 딸 수 없다. 
// 벌이 시작한 장소는 딸 수 없음.
// 벌들이 딸 수 있는 가장 최대의 꿀의 양을 계산해라. 

// 시간복잡도
// N은 10만까지 가능. 
// 각 장소의 꿀의 양은 10000 이하으 정수이다. 
// BFS 로는 힘들어보인다. 너무 큼.
// 누적합?
// 꿀통이 3 번이고 벌이 10 에 있다면 10 - 3 하면 되는거 아닌가? 
// 왼쪽에 있던, 오른쪽에 있던 똑같은데. 

// ## 주의
// 벌이 시작한 장소는 0으로 초기화 필요
// 합산하는 로직은 long 으로 처리해야한다. 
// 경우의수는 꿀통이 가장 오른쪽일때, 왼쪽일떄, 중간일때 로 나눌 수 있다

class boj_21758 {
    public static long[] dp;
    public static int[] arr;
    public static int N;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

        // 1부터 시작. 1 ~ N
        dp = new long[N+1];
        arr = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(st.nextToken());
            
            dp[i+1] = dp[i] + input;
            arr[i+1] = input;
        }

        long max = Long.MIN_VALUE;
        
        // 왼쪽
        for(int i=2;i<N;i++){
            max = Math.max(max , countL(i));
        }
        
        // 오른쪽
        for(int i=2;i<N;i++){
            max = Math.max(max ,countR(i));
        }
        
        // 가운데
        for(int i=2;i<N;i++){
            max = Math.max(max,countMid(i));
        }        
        
        System.out.println(max);
        
    }

    // 벌통이 왼쪽 끝. 
    public static long countL(int index){
        // 1~ N-1
        long sum = 0;

        sum += dp[index] - arr[index];
        sum += dp[N] - arr[N] - arr[index];

        return sum;
    }

    // 벌통이 오른쪽 끝. 
    public static long countR(int index){
        // 2~ N
        long sum = 0;

        sum += dp[N] - dp[index];
        sum += dp[N] - arr[1] - arr[index];

        return sum;
    }

    // 벌통이 가운데. 
    public static long countMid(int index){
        long sum = 0;

        sum += dp[index] - arr[1];
        sum += dp[N]- dp[index-1] - arr[N];

        return sum;
    }

}
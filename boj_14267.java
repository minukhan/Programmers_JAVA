
import java.util.*;
import java.lang.*;
import java.io.*;

// 4:19
// 상사가 직속 부하를 칭찬하면 그 부하가 그 부하의 직속부하를 연쇄적으로 칭찬 -> 재귀?
// 트리?
// 칭찬의 정도를 의미하는 수치가 있는데 이 수치 또한 부하들에게 똑같이 칭찬받는다. 
// 직속 상사와 직속 부하관계에 대해 주어진다. 
// 칭찬의 정보가 주어진다. 
// 각자 얼마의 칭찬을 받았는지 출력해라. 
// 회사의 직원수, : N
// 최초의 칭찬의 횟수 : M
// 직원은 1부터 N 까지 번호가 매겨져있다. 
// 직속 상사의 번호는 자신의 번호보다 작음. 
// 최종적으로 1번이 사장이다. 
// 상사가 없으므로 -1 이 입력된다. 
// 다음 M 줄에는 그냥 그래프를 만들어서. 다 돌리면 되는거 아닌가?ㅣ 


// 시간복잡도 
// N 은 10만, m 도 10만.
// 최악인경우 시간초과. 
// 그냥 완탐으로는 안됨 .
// 근데 이거 그떄 했던 그거 아님? 
// 아 근데 순서가 정해져있으면 그건데. 누적합. 
// 그 서브트리마다 기록?
// 서브트리들을 다 가지고있다 쳐도. 그걸 다 더하면 시간초과임. 
// 어떻게해야할까? DP? 이전꺼를 어디서 이용할 수 있지? 
// 상사가 받았다는건. 직원도 받아야하는거 아님? 
// 상사가 10이면 직원은 10보단 크겠지.
// 그래프를 위에서 오면서 누적합.
// N번을 돌면서 내껏만? 추가? 
// 그런 다음에 누적합? 1부터 돌면서 저장하고 출력.

class boj_14267 {
    public static ArrayList<Integer>[] list;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        
        for(int i=1;i<N+1;i++){
            int index = Integer.parseInt(st.nextToken());
            if(index == -1) continue;
            
            list[index].add(i);
        }

        dp = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            dp[index] += weight;
        }


        dfs(1,dp[1]);

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<N+1;i++){
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb.toString());
        
    }

    public static void dfs(int index, int result){

        for(int value : list[index]){
            dfs(value, result + dp[value]);
        }

        dp[index] = result;
        return;
        
    }
}
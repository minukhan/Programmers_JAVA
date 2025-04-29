import java.util.*;
import java.lang.*;
import java.io.*;

// 9:53
// 축구는 오후에하고 의무 참석도 아님.
// 축구를 하기위해 모인사람은 N명 N은 짝수임.
// 스타트 팀 반 링크팀 반 이렇게 나눈다.
// 같은팀에 속했을때 능력치가 주어진다. 
// 재밌게 축구하기위해 능력치의 차이를 최소로하려한다. 최소값을 출력해라.
// N은 20까지 -> 완탐은 안되고 빽트래킹
// 능력치는 100보다는 작다. 10 * 10 = 100 * 100 int 충분히 가능.
// 반으로 나눠야하는데 조합이네. 반으로 나누면 최악 10, 10 이고 
// 리스트들이 쭉 있으면 for문 돌려서 값 찾은다음 비교. back트래킹이니까 가능할듯.
// 최대 10*10 이긴한데 흠.. 애매하네 찾으면서 넣으면 좀더 효율적이긴하겠는데 

class boj_14889 {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[] team;
    public static int[][] score;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        team = new int[N+1];
    
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st  = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,1);
        System.out.println(min);
    }

    public static void dfs(int count, int index){
        
        if(count == N/2){
            calculate();
            return;
        }

        for(int i=index;i<=N;i++){
            team[i] = 1;
            dfs(count +1, i+1);
            team[i] = 0;
        }
    }

    public static void calculate(){
        int sumStart = 0;
        int sumLink = 0;
        
        HashSet<Integer> setStart = new HashSet<>();
        HashSet<Integer> setLink = new HashSet<>();

        for(int i=1;i<N+1;i++){
            if(team[i] == 1){
                setStart.add(i);
            }
            else{
                setLink.add(i);
            }
        }


        for(int value: setStart){
            for(int result : setStart){
                sumStart += score[value-1][result-1];
            }
        }

        for(int value: setLink){
            for(int result : setLink){
                sumLink += score[value-1][result-1];
            }
        }

        min = Math.min(min,Math.abs(sumStart - sumLink));
    }
}
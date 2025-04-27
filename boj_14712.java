import java.util.*;
import java.lang.*;
import java.io.*;
//3:12

// 1부터 N까지 번호가 매겨져 있는 도시들이 있다. 
// 도시들 사이에는 길이 있는데 없을 수 있다. 
// 한 도시에서 출발해서 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회여행경로
// 를 계획하려고한다. 이떄 한번 갔던 도시로는 다시 갈 수 없음.
// 여러가지의 경로가 있을 수 있는데 가장 적은 비용을 들이는 여행계획을 세우고자한다. 
// 비용은 대칭적이지 않고 모든 도시간의 비용은 양의 정수
// 도시에서 도시로 비용이 0인경우에는 갈 수 없는것. 가장 적은 비용으로 여행 경로를 찾아.
// 비용은 1,000,000 이고 N은 10이므로 총 100개가 가능. 이때 다 돈다해도 1억이므로 int가능
// 다익스트라는 최단거리로 가는것만이니까 돌아오는것도 중복이 안되니까 안될듯.
// 그럼 완전탐색임. -> N 은 10이므로 최악 10! 인데 종료조건이 있으니까 ㄱㅊ을듯.
// 종료조건은 그러면 N인가? count 를 이용해서? 중복안되는 순열? visited
class boj_14712 {
    
    public static int[][] cost;
    public static int N;
    public static int[] visited;
    public static int min;
    public static int init;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        cost = new int[N][N];
        visited = new int[N];
        min = Integer.MAX_VALUE;
            
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            init = i;
            dfs(0,0,i);
        }
        
        System.out.println(min);
    }

    public static void dfs(int count, int sum, int current){

        if(count == N){
            if(current == init){
                min = Math.min(min, sum);
            }
            return;
        }

        for(int i=0;i<N;i++){

            if(visited[i] == 1) continue;
            if(cost[current][i] == 0) continue;

            visited[i] = 1;
            dfs(count + 1, sum + cost[current][i], i);
            visited[i] = 0;
        }
    }
}

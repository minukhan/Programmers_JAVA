import java.util.*;
import java.lang.*;
import java.io.*;

// 11:51

// 컴퓨터와 네트워크 상에서 연결되어있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
// 서로 연결되어있는 정보가 주어짐.
// 바이러스에 걸리게 되는 컴퓨터의 수를 출력해라.
// 연결되어있으면 다 걸리는거니까
// 그냥 연결된 갯수를 세서 출력해라 이말이네? 
// 1번이 걸렸다고 생각하고 1번이 걸리면 어디까지 가느냐?
// dfs, bfs 둘다 상관없는데 나는 bfs 가 더 익숙하니까 bfs 로 ㄱㄱ

class boj_2606 {

    public static ArrayList<Integer>[] list;
    public static int[] visited;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new int[N+1];
        
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
        
            list[from].add(to);
            list[to].add(from);
        }

        bfs();

        int count=0;
        for(int i=0;i<N+1;i++){
            if(visited[i] == 1){
                count++;
            }
        }

        System.out.println(count -1);
        
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = 1;

        while(!queue.isEmpty()){
            int index = queue.poll();

            for(int value : list[index]){

                if(visited[value] == 1) continue;

                visited[value] = 1;
                queue.add(value);
            }
        }
    }

}
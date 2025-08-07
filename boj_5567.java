
import java.util.*;
import java.lang.*;
import java.io.*;

// 3: 27

// 동기는 모두 N명
// 1부터 N까지이다. 
// 학번은 1이다. 
// n은 500까지 
// 리스트의길이 m 1만
// 관계가 주어진다. 그래프 문제.

class boj_5567 {
    public static int N;
    public static int M;
    public static ArrayList<Integer>[] list ;
    public static int[] visited;
    public static int count =0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new int[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        bfs();

        System.out.println(count);
        
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = 1;
        int limit = 2;
        while(limit > 0 && !queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                int current = queue.poll();
    
                for(int value : list[current]){
    
                    if(visited[value] == 1) continue; 
    
                    count++;
                    visited[value] = 1;
                    queue.add(value);
                }
            }
            limit--;
        }
        
    }
}
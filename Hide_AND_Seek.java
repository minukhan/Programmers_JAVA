import java.util.*;
import java.lang.*;
import java.io.*;

class Hide_AND_Seek {

    public static int n;
    public static int K;
    public static boolean[] visited;
    public static int[] count;
    
    public static void Hide_AND_Seek(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[200000];
        count = new int[200000];

        bfs();
        
        System.out.println(count[K]);
    }

    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;
        count[n] = 0;

        while(!queue.isEmpty()){

            int N = queue.poll();
            
            if(N < K && !visited[N+1]){
                queue.add(N+1);
                visited[N+1] = true;
                count[N+1] = count[N] + 1; 
            }

            if(N-1>=0 && !visited[N-1]){
                queue.add(N-1);
                visited[N-1] = true;
                count[N-1] = count[N] + 1; 
            } 
            if(N*2 < 200000 && !visited[N*2]){
                queue.add(N*2);
                visited[N*2] = true;
                count[N*2] = count[N] + 1; 
            } 
        }
    }
}
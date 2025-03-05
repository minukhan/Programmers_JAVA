import java.util.*;
import java.lang.*;
import java.io.*;

class TreeSolution {

    public static boolean[] visited;
    public static ArrayList<Integer>[] tree;
    public static int count=0;
    
    public static void TreeSolution(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // integer 배열 list 생성
        tree = new ArrayList[N];
        for(int i=0;i<N;i++){
            tree[i] = new ArrayList<Integer>();
        }

        // 배열 값 저장.
        st.nextToken();          
        for(int i=1;i<N;i++){
            tree[Integer.parseInt(st.nextToken())].add(i);          
        }

        
        int delete = Integer.parseInt(br.readLine());
        
        visited = new boolean[N];


        if(delete != 0){
            int parentNode = bfs(delete);

            for(int i=0;i<tree[parentNode].size();i++){
                if(tree[parentNode].get(i) == delete){
                    tree[parentNode].remove(i);
                }
            }
    
            for(int i=0;i<N;i++){
                visited[i] = false;
            }
    
            dfs(0);
            
            System.out.println(count);
        }
        else{
            System.out.println(count);
        }
        
    }

    // 부모를 찾아주는 bfs
    public static int bfs(int n){
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
    
            for(int value : tree[node]){
                if(value == n){
                    return node;
                }
                if(visited[value]) continue;

                queue.add(value);
                visited[value] = true;
            }
        }

        return -1;
    }


    public static void dfs(int node){

        visited[node] = true;
        
        if(tree[node].isEmpty()){
            count++;
            return;
        }

        for(int value : tree[node]){
            if(visited[value]) continue;

            dfs(value);
        }
    }
    
}
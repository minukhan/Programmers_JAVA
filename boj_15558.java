import java.util.*;
import java.lang.*;
import java.io.*;


class boj_15558 {
    public static int N;
    public static int K;
    public static boolean[][] visited;

    static class Node{
        int line;
        int index;
        public Node(int line, int index){
            this.line = line;
            this.index = index;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[3][N + K + 1];

        for(int i=1;i<3;i++){
            Arrays.fill(visited[i] , true);
        }
        
        for(int i=1;i<3;i++){
            String input = br.readLine();
            
            for(int j=0;j<N;j++){
                if(input.charAt(j) == '0'){
                    visited[i][j] = false; 
                }
            }
        }

        bfs();
    }

    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        visited[1][0] = false;
        int count =-1;
        while(!queue.isEmpty()){

            int T = queue.size();
            
            while(T > 0){
                
                Node node = queue.poll();

                if(node.index <= count){
                    T--;
                    continue;
                }
                if(node.index >= N){
                    System.out.println(1);
                    return;
                }
    
                // 한칸 앞으로 가기
                if(visited[node.line][node.index+1]){
                    queue.add(new Node(node.line, node.index+1));
                    visited[node.line][node.index+1] = false;
                }
                
                // 한칸 뒤로가기
                if(node.index - 1 >= 0 && visited[node.line][node.index-1]){
                    queue.add(new Node(node.line, node.index-1));
                    visited[node.line][node.index-1] = false;
                }
                
                // 반대편 줄로 점프하기
                int change =1;
                if(node.line == 1){
                    change = 2;
                }
                if(visited[change][node.index+K]){
                    queue.add(new Node(change, node.index+K));
                    visited[change][node.index+K] = false;
                }
                
                T--;
            }

            count++;
            for(int i=1;i<3;i++){
                visited[i][count] = false;
            }

        }

        System.out.println(0);
    }
}
























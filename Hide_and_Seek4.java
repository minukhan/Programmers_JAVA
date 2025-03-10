import java.util.*;
import java.io.*;

class Hide_and_Seek4 {

    public static int N;
    public static int M;
    public static boolean[] visited;
    public static int max;
    public static int answer;
    public static String result;
    
    static class Node {
        int index;
        int count;
        StringBuilder code;
        
        public Node(int index, int count, StringBuilder code) {
            this.index = index;
            this.count = count;
            this.code = code;
        }
    }
    
    public static void Hide_and_Seek4(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = Math.max(N, M);
        visited = new boolean[max + 1];
        answer = Integer.MAX_VALUE;
        
        bfs();

        System.out.println(answer);
        System.out.println(result);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        StringBuilder init = new StringBuilder();
        init.append(N).append(" ");
        queue.add(new Node(N, 0, init));
        visited[N] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.index == M){
                if(answer > node.count){
                    answer = node.count;
                    result = node.code.toString();
                }
                answer = Math.min(answer, node.count);
            }
            
            if(node.index > M){
                if(node.index - 1 > 0 && !visited[node.index - 1]){
                    StringBuilder sb = new StringBuilder(node.code);
                    sb.append((node.index - 1)).append(" ");
                    queue.add(new Node(node.index - 1, node.count + 1, sb));
                    visited[node.index - 1] = true;
                }
            }
            else{
                if(node.index + 1 <= max && !visited[node.index + 1]){
                    StringBuilder sb = new StringBuilder(node.code);
                    sb.append((node.index + 1)).append(" ");
                    queue.add(new Node(node.index + 1, node.count + 1, sb));
                    visited[node.index + 1] = true;
                }
                if(node.index * 2 <= max && !visited[node.index * 2]){
                    StringBuilder sb = new StringBuilder(node.code);
                    sb.append((node.index * 2)).append(" ");
                    queue.add(new Node(node.index * 2, node.count + 1, sb));
                    visited[node.index * 2] = true;
                }
            }
        }
    }
}

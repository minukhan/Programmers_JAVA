
import java.util.*;
import java.lang.*;
import java.io.*;


class boj_16928 {

    public static int N;
    public static int M;
    public static HashMap<Integer, Integer> map;
    public static int[] visited;

    static class Node{
        int index;
        int count;
        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         map = new HashMap<>();
        
        for(int i=0;i<N + M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            map.put(first, second);
        }

        visited = new int[101];
        
        bfs();
        
    }
    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        visited[1] = 1;

        while(!queue.isEmpty()){
            Node node  = queue.poll();

            int current = node.index;
            
            if(current == 100){
                System.out.println(node.count);
                return;
            }

            for(int i=1;i<7;i++){
                int next = current + i;

                if(next > 100) continue;

                int prevValue = next;
                int value = map.getOrDefault(next , -1);


                // 만약 사다리나 뱀이 있다면
                while(value != -1){
                    prevValue = value; 
                    value = map.getOrDefault(value , -1);
                }
                
                // 만약 사다리나 뱀이 없다면
                if(visited[prevValue] == 1) continue;

                queue.add(new Node(prevValue,node.count + 1));
                visited[prevValue] = 1;
            }
        }
    }
}
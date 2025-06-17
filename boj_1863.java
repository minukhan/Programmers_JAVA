import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1863 {

    static class Node{
        int x;
        int y;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        int check = 0;
        int current = 0;
        int count =0;
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().y > y) {
                stack.pop();
                count++;
            }
            
            if (stack.isEmpty() || stack.peek().y < y) {
                if (y != 0) {
                    stack.push(new Node(y, x));
                }
            }

            if(i == N-1){
                check = y;
            }
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            count++;
        }

        System.out.println(count);
    }
}






















import java.util.*;
import java.lang.*;
import java.io.*;

class boj_22866 {
    static class Node{
        int size;
        int near;
        public Node(int size, int near){
            this.size = size;
            this.near = near;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        

        int[] building = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            building[i] = Integer.parseInt(st.nextToken());    
        }

        Stack<Integer> stack = new Stack<>();
        Node[] left = new Node[N];
        
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                left[i] = new Node(stack.size(), stack.peek());
            } 
            else {
                left[i] = new Node(0, -1);
            }
            stack.push(i);
        }

        
        stack = new Stack<>();
        Node[] right = new Node[N];
        
        for (int i = N-1; i >=0; i--) {
            while (!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                right[i] = new Node(stack.size(), stack.peek());
            } 
            else {
                right[i] = new Node(0, -1);
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        
        for(int i=0;i<N;i++){
            int count = left[i].size + right[i].size;
            if(count == 0){
                sb.append("0\n");
                continue;
            }
            
            int index =0;
            int leftDist = left[i].near != -1 
               ? Math.abs(i - left[i].near) 
               : Integer.MAX_VALUE;

            int rightDist = right[i].near != -1 
                ? Math.abs(i - right[i].near) 
                : Integer.MAX_VALUE;

            if(leftDist > rightDist) index = right[i].near;
            else index = left[i].near;

            sb.append(count).append(" ").append(index+1).append("\n");
        }

        System.out.println(sb.toString());

        
    }
}
























import java.util.*;
import java.lang.*;
import java.io.*;


class boj_11000 {
    static class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> endQueue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1, o2)
        );
        
        PriorityQueue<Node> startQueue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.start, o2.start)
        );

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            startQueue.add(new Node(start, end));
        }

        while(!startQueue.isEmpty()){
            Node node = startQueue.poll();
            
             if(!endQueue.isEmpty() && endQueue.peek() <= node.start){
                endQueue.poll();
            }
            endQueue.add(node.end);
        }

        System.out.println(endQueue.size());
    }
}
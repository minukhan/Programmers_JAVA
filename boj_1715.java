import java.lang.*;
import java.io.*;

class boj_1715 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o1 - o2);

        for(int i=0;i<N;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;

        if(queue.size() ==1){
            System.out.println(0);
            return;
        }

        int size = queue.size();
        while(size > 1){
            size--;
            int first = queue.poll();
            int second = queue.poll();
            sum = sum + first + second;
            queue.add(first + second);
        }

        System.out.println(sum);
    }
}

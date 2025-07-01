import java.util.*;
import java.lang.*;
import java.io.*;

class boj_13975 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            st=  new StringTokenizer(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>(
                (o1,o2) -> Long.compare(o1, o2)
            );
            
            for(int i=0;i<N;i++){
                queue.add(Long.parseLong(st.nextToken()));
            }

            long answer =0;

            while(queue.size() > 1){
                long first = queue.poll();
                long second = queue.poll();

                answer = answer + first + second;

                queue.add(first+second);
            }

            System.out.println(answer);


        }
    }
}
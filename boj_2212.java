import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2212 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o2,o1)
        );
        
        for(int i=0;i<N-1;i++){
            queue.add(arr[i+1] - arr[i]); 
        }

        int answer = 0;

        for(int i=0;i<K-1;i++){
            if(!queue.isEmpty()){
                int count = queue.poll();
                answer += count;
            }
        }

        System.out.println((max - min) - answer);
        
    }
}
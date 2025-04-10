import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1202 { //1:38

    static class Ruby{
        int weight;
        int price;
        public Ruby(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }
    public static int K;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
            
        ArrayList<Ruby> list = new ArrayList<>();
                
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            
            list.add(new Ruby(weight,price));
        }

        list.sort((o1, o2) ->{
            return Integer.compare(o1.weight , o2.weight);
        });
        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        long answer =0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o2,o1));

        int j=0;
        for(int i=0;i<K;i++){
            int size = bag[i];

            while(j < N && list.get(j).weight <= size){
                queue.add(list.get(j).price);
                j++;
            }

            if(!queue.isEmpty()){
                answer += queue.poll();
            }
        }
        

        

        System.out.println(answer);

    }
    
}
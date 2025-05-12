import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[10001];
        for(int i=0;i<10001;i++){
            list[i] = new ArrayList<>();
        }
        int maxIndex =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            
            int price = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            list[index].add(price);
            maxIndex = Math.max(maxIndex, index);
        }
        
        int result = 0;
        
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=maxIndex;i>=1;i--){
            
            for(int value : list[i]){
                answer.add(value);
            }

            if(answer.size() == 0) continue;

            answer.sort(Comparator.reverseOrder());
            result = result + answer.get(0);
            answer.remove(0);
        }
        
        System.out.println(result);
    }
}
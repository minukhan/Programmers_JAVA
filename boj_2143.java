import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2143 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        for(int i=0;i<N;i++){
            int sum = A[i];
            mapA.put(sum,  mapA.getOrDefault(sum, 0) + 1);

            for(int j=i+1;j<N;j++){
                sum += A[j];
                mapA.put(sum,  mapA.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int i=0;i<M;i++){
            int sum = B[i];
            mapB.put(sum,  mapB.getOrDefault(sum, 0) + 1);

            for(int j=i+1;j<M;j++){
                sum += B[j];
                mapB.put(sum,  mapB.getOrDefault(sum, 0) + 1);
            }
        }

        long answer =0;
        
        for(int value : mapA.keySet()){
            int result = T - value;
            if(mapB.containsKey(result)){
                answer += (long)mapA.get(value) * mapB.get(result);
            }
        }

        System.out.println(answer);

    }
}
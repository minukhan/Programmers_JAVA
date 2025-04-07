import java.util.*;
import java.io.*;

class boj_7453 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrayAB = new int[N * N];
        int index =0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arrayAB[index] = A[i] + B[j];
                index++;
            }
        }

        int[] arrayCD = new int[N * N];
        index =0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arrayCD[index] = C[i] + D[j];
                index++;
            }
        }

        Arrays.sort(arrayAB);
        Arrays.sort(arrayCD);

        long answer =0;
        int L = 0;
        int R = N * N -1;

        while(L < N*N && R >= 0){
            if(arrayAB[L] + arrayCD[R] < 0){
                L++;
            }
            else if(arrayAB[L] + arrayCD[R] > 0){
                R--;
            }
            else{
                long countAB = 1;
                long countCD = 1;

                while(L+1 < N*N && arrayAB[L] == arrayAB[L+1]){
                    L++;
                    countAB++;
                }
                while(R-1 >= 0 && arrayCD[R] == arrayCD[R-1]){
                    countCD++;
                    R--;
                }

                answer = answer + countAB * countCD;
                L++;
                R--;
            }
        }
        System.out.println(answer);
    }
}
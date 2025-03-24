import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2473 {
    public static void boj_2473(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] input = new int[N];

        for(int i=0;i<input.length;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int[] answer = new int[3];
        long max = Long.MAX_VALUE;

        for(int i=0;i<N;i++){
            int first = input[i];

            int L = 0;
            int R = N-1;

            while(L < R){
                if(L==i){
                    L++;
                    continue;
                }
                if(R==i){
                    R--;
                    continue;
                }

                long sum = first + input[L] + input[R];

                if(Math.abs(sum) < max){
                    max = Math.abs(sum);
                    answer[0] = first;
                    answer[1] = input[L];
                    answer[2] = input[R];
                }
                if(sum <= 0){
                    L++;
                }
                else if(sum > 0){
                    R--;
                }
            }
        }

        Arrays.sort(answer);
        StringBuilder sb = new StringBuilder();
        
        for(int value : answer){
            sb.append(value).append(" ");
        }
        
        System.out.println(sb.toString());
        
    }
}
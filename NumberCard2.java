import java.util.*;
import java.lang.*;
import java.io.*;

class NumberCard2 {
    public static void NumberCard2(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st =new StringTokenizer(br.readLine());

        int[] count = new int[20000001];

        for(int i=1;i<N+1;i++){
            int value = Integer.parseInt(st.nextToken());
            if(value <0){
                value = Math.abs(value) + 10000000;
            }

            count[value] ++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<M+1;i++){
            int value = Integer.parseInt(st.nextToken());
            if(value <0){
                value = Math.abs(value) + 10000000;
            }
            sb.append(count[value]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
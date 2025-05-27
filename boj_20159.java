import java.util.*;
import java.lang.*;
import java.io.*;

class boj_20159 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        long[] odd = new long[N/2 +2];
        long[] even = new long[N/2 +2];
        
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index =0;
        for(int i=1;i<=N;i=i+2){
            odd[index + 1] = odd[index] + arr[i];
            index++;
        }

        index =0;
        for(int i=2;i<=N+1;i=i+2){
            even[index+1] = even[index] + arr[i];
            index++;
        }

        long max = odd[N/2];
        long result;
        for(int i=0;i<N;i++){

            if(i%2 == 1){
                 result = even[N/2] - even[i/2] + odd[i/2];
            }
            else{
                 result = even[N/2-1] + odd[i/2+1] - even[i/2];
            }

            max = Math.max(max,result);
        }

        System.out.println(max);
    }
}
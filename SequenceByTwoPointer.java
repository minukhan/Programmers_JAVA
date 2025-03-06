import java.util.*;
import java.lang.*;
import java.io.*;

class SequenceByTwoPointer {
    public static void SequenceByTwoPointer(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = Integer.MIN_VALUE;
        int sum =0;
        
        int L =0;
        int R =0;
        
        while(R-L != K-1){
            R++;
        }

        for(int i=L;i<=R;i++){
            sum += temp[i];
        }

        max = sum;

        while(R != N-1){
            R++;
            sum += temp[R];
            sum -= temp[L]; 
            L++;
            
            max = Math.max(max,sum);
        }
        
        
        System.out.println(max);
    }
}
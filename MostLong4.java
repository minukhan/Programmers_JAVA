import java.util.*;
import java.lang.*;
import java.io.*;

class MostLong4 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] number = new int[N];
        int[] upDp = new int[N];
        int[] downDp = new int[N];

        Arrays.fill(upDp,1);
        Arrays.fill(downDp,1);
        
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(number[i] > number[j]){
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1); 
                }
            }
        }

        for(int i=N-1;i>=0;i--){
            for(int j=i;j<N;j++){
                if(number[i] > number[j]){
                    downDp[i] = Math.max(downDp[i], downDp[j] + 1); 
                }
            }
        }
        int max =Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            max = Math.max(max,upDp[i] + downDp[i] - 1);
        }
        
        System.out.println(max);
    }
}
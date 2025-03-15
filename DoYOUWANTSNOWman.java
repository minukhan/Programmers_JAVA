import java.util.*;
import java.lang.*;
import java.io.*;

class DoYOUWANTSNOWman {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st =new StringTokenizer(br.readLine());

        int[] height = new int[N];

        for(int i=0;i<N;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(height);

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){

                int first = height[i] + height[j];

                int L = 0; 
                int R = N-1;

                while(L < R){
                    int second = height[L] + height[R];

                    if(L == i || L == j){
                        L++;
                        continue;
                    }

                    if(R == i || R == j){
                        R--;
                        continue;
                    }

                    min = Math.min(min, Math.abs(first - second));
                    
                    if(second < first){
                        L++;
                    }
                    else{
                        R--;
                    }
                }
            }
        }
        
        System.out.println(min);
    }
}
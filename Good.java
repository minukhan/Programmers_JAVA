
import java.util.*;
import java.lang.*;
import java.io.*;

class Good {
    public static void Good(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] number = new int[n];
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        int count=0;
        
        for(int i=0;i<n;i++){

            int L = 0;
            int R = n-1;

            while(L<R){
                if(L == i){
                    L++;
                    continue;
                }
                if(R==i){
                    R--;
                    continue;
                }
                
                int sum = number[L] + number[R];

                if(sum == number[i]){
                    count++;
                    break;
                }
                else if(sum < number[i]){
                    L++;
                }
                else{
                    R--;
                }
                
            }
            
        }

        
        System.out.println(count);
    }
}
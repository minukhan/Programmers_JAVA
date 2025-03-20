import java.util.*;
import java.lang.*;
import java.io.*;

class NumberTie {
    public static void NumberTie(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(br.readLine());
        }
      
        Arrays.sort(number);
        
        if(N==1){
            System.out.println(number[0]);
            return;
        }
        
        int answer =0;
        int index=0;
        
        for(int i=N-1;i>=0;i--){
            if(i-1 < 0) continue;

            int first = number[i];
            int second = number[i-1];
            if(first > 1 && second > 1){
                
                number[i] = 0;
                number[i-1] = 0;
                answer+= first * second;
                i--;
            }
            else{
                index = i;
                break;
            }
        }

        for(int i=0;i<=index;i++){
            if(i+1 > index) continue;

            int first = number[i];
            int second = number[i+1];

            if(first<=0 && second <=0){
                number[i] = 0;
                number[i+1] = 0;
                answer+= first * second;
                i++;
            }
        }
        
        for(int value : number){
            answer += value;
        }
        
        System.out.println(answer);
    }
}

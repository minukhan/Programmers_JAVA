
import java.util.*;
import java.lang.*;
import java.io.*;

class boj_2138 {
    public static int result;
    public static int N;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String input2 = br.readLine();

        boolean[] first = new boolean[N];
        boolean[] zeroFirst = new boolean[N];
        boolean[] second = new boolean[N];

        for(int i=0;i<N;i++){
            int firstInput = input.charAt(i) - '0';
            int secondInput = input2.charAt(i) - '0';

            if(firstInput == 1){
                first[i] = true;
                zeroFirst[i] = true;
            }
            if(secondInput == 1) second[i] = true;
        }

        int answer=0;


        // 첫자리가 다를경우 0부터 시작하는 경우. 
        result = 0;
        if (zeroFirst[0] != second[0]) {
            turn(0, zeroFirst);
        }
        
        turn(0, zeroFirst);
        for(int i=0;i<N-1;i++){
            if(zeroFirst[i] == second[i]) continue;
            
            turn(i+1, zeroFirst);
        }
        if(zeroFirst[N-1] != second[N-1]) result = Integer.MAX_VALUE;
            
        answer = result;
        
        // 첫자리가 다를경우 1부터 시작하는 경우. 
        result = 0;
        for(int i=0;i<N-1;i++){
            if(first[i] == second[i]) continue;
            turn(i+1, first);
        }
        if(first[N-1] != second[N-1]) result = Integer.MAX_VALUE;

        answer = Math.min(answer, result);

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }

    public static void turn(int index, boolean[] first){

        if(index == 0){
            if(first[0]) first[0] = false;
            else first[0] = true;

            if(first[1]) first[1] = false;
            else first[1] = true;
            
            result++;
            return;
        }

        // 마지막 전구 누를 때 (i = N-1)
        if (index == N - 1) {
            first[index - 1] = !first[index - 1];
            first[index]     = !first[index];
            result++;
            return;
        }

        for(int i=0;i<3;i++){
            if(first[i+index-1]) first[i+index-1] = false;
            else first[i+index-1] = true;
        }
        result++;
        
        
    }
}

















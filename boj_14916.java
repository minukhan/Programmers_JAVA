import java.util.*;
import java.lang.*;
import java.io.*;

class boj_14916 { // 4:35
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int five = n / 5;
        int remain = n % 5;

        if(remain % 2 == 1){
            five--;
            remain+= 5;
        }
        int answer =0;
        
        if(five >= 0){
            answer += remain / 2;
            answer += five;
            System.out.println(answer);
            
        }
        else{
            answer = -1;
            System.out.println(answer);
        }

    }
}
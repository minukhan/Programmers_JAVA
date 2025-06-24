import java.util.*;
import java.lang.*;
import java.io.*;

class boj_20364 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int max = (int)Math.pow(2,20) + 1;
        
        int[] check = new int[max];

        for(int i=0;i<Q;i++){

            int index = Integer.parseInt(br.readLine());
            
            check[1] = 1;

            int start = index;
            int answer = 0;
            while(true){
    
                if(check[start] == 1){
                    answer = start;
                }
                
                start = start / 2;
                
                if(start <= 1){
                    check[index] = 1;
                    System.out.println(answer);
                    break;
                }
            }
        }
        
    }
}
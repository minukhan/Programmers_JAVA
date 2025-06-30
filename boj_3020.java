import java.util.*;
import java.lang.*;
import java.io.*;



class boj_3020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int prev = 0;

        int[] odd = new int[500001];
        int[] even = new int[500001];

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());

            if(i%2== 0){
                prev++;
                even[input]++;
            }
            else{
                odd[input]++;
            }
        }

        int min = prev;
        int count =1;
        
        for(int i=2;i<H+1;i++){

            int next = prev - even[i-1] + odd[H-i+1];

            if(min > next){
                min = next;
                count =1;
            }
            else if(min == next){
                count++;
            }

            prev = next;

        }
        
        System.out.println(min + " " + count);
    }
}
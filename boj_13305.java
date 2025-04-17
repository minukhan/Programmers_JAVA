import java.util.*;
import java.lang.*;
import java.io.*;


class boj_13305 { // 5:20
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dist = new int[n+1];
        for(int i=1;i<n;i++){

            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] city = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            city[i] = Integer.parseInt(st.nextToken());
        }
        long answer =0;

        int i=0;
        while(i<n){

            int current = city[i];

            long sum =0;

            int j=1;
            while(i<n){

                if(i+j>=n) break;
                sum += dist[i+j];
            
                if(current > city[i+j]){
                    break;
                }
                else{
                    j++;
                }
            }

            answer += sum * current;
            i = i+j;
            
        }
    
        System.out.println(answer);
    }
}

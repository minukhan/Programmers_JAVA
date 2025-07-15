
import java.util.*;
import java.lang.*;
import java.io.*;


// 수 고르기
// N 개의 정수로 이루어진 수열이 있다. 
// 이 수열에서 두 수를 골랐을때 그 차이가 M 이상이면서 제일 작은 경우를 구해라. 
// 가장 작은 차이를 출력해야하는데. 그러면 모든경우를 다 보고싶지만
// N 이 10만개라 다 못봄. M은 20억까지 가능. 
// long 으로 처리해야함. 
// 수열을 정렬하면? 

// 뒤에 큰거, 앞에 작은거.
// 투포인터를 이용해서 N 으로 해결볼 수 있지 않을까?
// 합이 크면 R 을 줄이고, 합이 작으면 L 을 키우고 하면 되지 않나? 
// 이때 long 을 사용해야하고. 


class boj_2230 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        int L = 0;
        int R = 1;
        long max = Long.MAX_VALUE;
        
        while(R < N){
            
            long diff = (long) Math.abs(arr[R] - arr[L]);

            if(L == R){
                R++;
                continue;
            }
            
            if(diff < M){
                R++;
            }
            else if(diff == M){
                max = diff;
                break;
            }
            else{
                max = Math.min(max, diff);
                L++;
            }
        }

        System.out.println(max);
        
    }
}
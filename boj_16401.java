import java.util.*;
import java.lang.*;
import java.io.*;

    
class boj_16401 {
    public static int[] arr;
    public static int N;
    public static int M;
    public static int max;
    public static int answer;
    
    
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new  StringTokenizer(br.readLine());

         M  = Integer.parseInt(st.nextToken());
         N  = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st =new  StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());    
            max = Math.max(max,arr[i]);
        }

        Arrays.sort(arr);
        
        binarySearch(1, max);

        System.out.println(answer);
        
    }

    public static void binarySearch(int L, int R){

        while(L <= R){
            int mid = R - (R-L) / 2;
            int count=0;
            
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= mid){
                    count += arr[i] / mid;
                }
            }
            if(count >= M){
                answer = mid;
                L = mid + 1;
            }
            else{
                R = mid -1;
            }
        }

    }
}
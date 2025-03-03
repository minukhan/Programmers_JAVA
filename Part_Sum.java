import java.util.*;
import java.lang.*;
import java.io.*;


class Part_Sum {
    public static int[] arr;
    public static int S;
    
    public static void Part_Sum(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        
        int rightIndex = 0;
        int sum =arr[0];
        
        for(int leftIndex=0;leftIndex<n;leftIndex++){

            if(leftIndex!=0){
                sum -= arr[leftIndex-1];
            }

            while(sum < S && rightIndex<n-1){
                rightIndex++;
                sum += arr[rightIndex];
            }
            if(sum >= S){
                min = Math.min(min, rightIndex-leftIndex + 1);
            }
        }

        if(min == Integer.MAX_VALUE){
            min =0;
        }
        
        System.out.println(min);
        
    }
}
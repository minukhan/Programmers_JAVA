import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class TwoPointerBasic {
    public static void TwoPointerBasic(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        
        int count =0;
        int L =0;
        int R = n-1;

        while(L<R){
            if((arr[L] + arr[R]) < X){
                L = L+1;
            }
            else if((arr[L] + arr[R]) > X){
                R = R -1;
            }
            else{
                count++;
                R=  R-1;
            }
        }

        
        System.out.println(count);
    }
}
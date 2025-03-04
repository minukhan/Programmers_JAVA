import java.util.*;
import java.lang.*;
import java.io.*;

class FindNumberByBinarySearch {

    public static int[] A;
    
    public static void FindNumberByBinarySearch(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine()); 
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for(int i=0;i<M;i++){
            System.out.println(binarySearch(0,N-1,B[i]));
        }
    }

    public static int binarySearch(int L, int R, int X){

        int result =0;
        
        while(L <= R){
            int mid = L + (R-L) /2;
            if(A[mid] == X){
                result =1;
                break;
            }
            else if(A[mid] < X){
                L = mid+1;
            }
            else{
                R = mid - 1;
            }
        }
        
        return result;
    }







    
}
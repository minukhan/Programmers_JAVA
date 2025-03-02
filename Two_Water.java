import java.util.*;
import java.lang.*;
import java.io.*;

class Two_Water {
    public static void Two_Water(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int number1 = 0;
        int number2 =0;

        Arrays.sort(array);
        
        for(int i=0;i<n;i++){
            int findIndex = binarySearch(array,i+1,n-1,-array[i]);



            // A[findIndex]가 유효한 경우
            if (findIndex < n && Math.abs(array[i] + array[findIndex]) < min) {
                min = Math.abs(array[i] + array[findIndex]);
                number1 = array[i];
                number2 = array[findIndex];
            }

            // A[findIndex - 1]도 유효한 경우
            if (findIndex > i + 1 && Math.abs(array[i] + array[findIndex - 1]) < min) {
                min = Math.abs(array[i] + array[findIndex - 1]);
                number1 = array[i];
                number2 = array[findIndex - 1];
            }
            
            
        }
        
        System.out.println(number1 + " " + number2);
    }

    public static int binarySearch(int[] array , int L, int R, int number){

        while(L<=R){

            int mid= L + (R-L) /2 ;

            if(array[mid] < number){
                L = mid +1 ;
            }
            else{
                R = mid -1;
            }
        }

        return L;
                
    }
}
import java.io.*;
import java.util.*;

public class Tree_plant {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input[i]);                
        }

        Arrays.sort(arr);
        
            System.out.println(Math.max(arr[0]*arr[1] , arr[n-1] * arr[n-2]));               
    }
}

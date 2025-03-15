import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int min = 100000000;
        
        int[] nums = new int[input.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        
        for(int i=0;i<nums.length-1;i++){
            
            min = Math.min(min, nums[i+1] - nums[i]);    
            
        }
        int answer=0;
        
        for(int i=0;i<n-1;i++){
            if(min == (nums[i+1] - nums[i])){
                answer++;
            }
        }

        System.out.println(answer);
    }
}

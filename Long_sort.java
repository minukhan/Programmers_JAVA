import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String num = String.valueOf(n);
        
        char[] arr = num.toCharArray();
        
        Arrays.sort(arr);
        
        num ="";
        
        for(int i=arr.length-1;i>=0;i--){
            num+= arr[i];
        }
        
        answer = Long.parseLong(num);
        
        return answer;
    }
}
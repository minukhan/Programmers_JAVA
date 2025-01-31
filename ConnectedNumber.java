import java.util.*;

class ConnectedNumber {
    public int[] ConnectedNumber(int[] sequence, int k) {
        
        int left=0;
        int right=0;
        int sum = 0;
        
        int minlen = Integer.MAX_VALUE;
        int leftIndex =0;
        int rightIndex =0;
        
        for(int i=0;i<sequence.length;i++){

            sum += sequence[right];
            right++;
                
            while(sum > k && left<right){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                int len = right - left +1; 
                if(len < minlen){
                    leftIndex = left;
                    rightIndex = right;
                    minlen = len;
                }
            }
            
        }
        
        int[] answer = {leftIndex, rightIndex-1};
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int j=1;
        boolean check = false;
        
        for(int i=0;i<order.length;i++){
            if(check){
                break;
            }
            while(true){
                if(order[i]==j){
                    answer++;
                        
                    j++;
                    break;
                }
                else{
                    if(!stack.isEmpty() && order[i]==stack.peek()){
                        
                        answer++;
                        stack.pop();
                        break;
                    }
                    else if(j<=order.length){
                        stack.push(j);
                        j++;
                    }
                    else{
                        check = true;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
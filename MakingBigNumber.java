import java.util.*;

class MakingBigNumber {
    public String MakingBigNumber(String number, int k) {
        
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char currentChar;
        
        for(int i=0;i<number.length();i++){
            
            currentChar = number.charAt(i);    
            
            while(true){
                if(!stack.isEmpty() && currentChar > stack.peek() && k!=0){
                    stack.pop();
                    k--;
                    continue;
                }
                break;
            }
            
            stack.push(currentChar);
        }
        while(k!=0){
            stack.pop();
            k--;
        }
        
        int n = stack.size();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}
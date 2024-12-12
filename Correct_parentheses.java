import java.util.Stack;

class Correct_parentheses {
    boolean Correct_parentheses(String s) {
        boolean answer = true;
    
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    answer = false;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
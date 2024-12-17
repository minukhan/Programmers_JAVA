import java.util.Stack;

class Lotaion_parenthesis {
    public int Lotaion_parenthesis(String s) {
        int answer = 0;
        String changeString =s;
        for(int i=0;i<s.length();i++){
            
            if(StackCheck(changeString)){
                answer++;
            }
            changeString = ShiftString(changeString);
        }
        
        return answer;
    }
    
    private boolean StackCheck (String s ){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            if(!stack.isEmpty()){
                
                if((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '{' && s.charAt(i) == '}')){
                    
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }

        
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    private String ShiftString (String s){
        
        String shift = "";
        
        for(int i=0;i<s.length();i++){
            shift += s.charAt((i+1) % s.length());
        }
        return shift;
    }
    
    
}
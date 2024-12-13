import java.util.Stack;

class Couple_Delete
{
    public int Couple_Delete(String s)
    {
        int answer = 0;
//         StringBuilder sb = new StringBuilder();
        
//         sb.append(s);
        
//             for(int i=0;i<sb.length();i++){
//                 if((i+1)<sb.length() && sb.charAt(i)==sb.charAt(i+1)){
//                     sb.delete(i,i+2);
//                     if(i>0){
//                        i = i -2;
//                     }
//                     else{
//                         i = -1;
//                     }
                    
//                 }
//             }
//         if(sb.length()==0){
//             answer =1;
//         }        
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)){
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
        
        if(stack.size()==0){
            answer = 1;
        }

        return answer;
    }
}
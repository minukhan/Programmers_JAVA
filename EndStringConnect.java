import java.util.Stack;

class EndStringConnect {
    public int[] EndStringConnect(int n, String[] words) {
        int count =0;
        int peopleindex = 0;
        
        // 중복되는지 확인해야함. contains -> 
        Stack<String> stack = new Stack<>();

        for(int i=0;i<words.length;i++){
            if(stack.isEmpty()){
                stack.push(words[i]);
                continue;
            }
            
            String preChar = stack.peek();
            
            if(preChar.charAt(preChar.length()-1)==words[i].charAt(0) && !stack.contains(words[i])){
                stack.push(words[i]);
            }
            else{
                count = ((i) / n) + 1;
                peopleindex = i % n +1;
                
                System.out.println("count : " + count);
                break;
                
            }
        }
        
        int[] answer = {peopleindex,count};
        
            
        return answer;
    }
}
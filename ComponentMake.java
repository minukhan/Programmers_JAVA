import java.util.*;

class ComponentMake {
    public int[] ComponentMake(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answerArr = new ArrayList<>();
        
        // 갯수 배열 생성
        for(int i=0;i<progresses.length;i++){
            if((100 - progresses[i]) % speeds[i] != 0){
                
                list.add((100 - progresses[i]) / speeds[i] + 1);
            }
            else{
                list.add((100 - progresses[i]) / speeds[i]);
            }
            System.out.println(list.get(i));
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<list.size();i++){
            
            for(int j=i+1;j<list.size();j++){
                
                if(list.get(i) >= list.get(j)){
                    stack.push(list.get(j));
                }
                else{
                    break;
                }
            }
            
            i += stack.size();
            
            answerArr.add(stack.size() + 1);
            
            stack.clear();
        }
        
        int[] answer = new int[answerArr.size()];
        
        for(int i=0;i<answerArr.size();i++){
            answer[i] = answerArr.get(i);
        }
        
        return answer;
    }
}
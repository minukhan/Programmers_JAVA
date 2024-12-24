import java.util.*;

class BackFindBigNumbers {
    public int[] BackFindBigNumbers(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            
                while(!stack.isEmpty() && numbers[i]>=stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    answer[i] = -1;                
                }
                else{
                    answer[i] = stack.peek();
                }
                stack.push(numbers[i]);
        }
        
        
        // 검사할께 작아 -> 그대로 그거 쓰면됨 바로 위에있는거 왜냐면 바로 뒤에있는 수 구하는거니까
        // 검사할때 커 -> 이러면 while 을 돌려서 pop을 시키면서 돌아서 찾아 근데 없으면 -1 그 큰값을 넣으므로 알고리즘엔 문제없음
        
        return answer;
    }
}
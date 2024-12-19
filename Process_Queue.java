import java.util.*;
class Process_Queue {
    public int Process_Queue(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int[] Array = priorities.clone();
        
        Arrays.sort(Array);
        
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
        }
        
        int index = Array.length -1;
        int targetIndex = location;
        
        while(true){
            if(queue.peek() == Array[index]){
                queue.poll();
                index--;
                answer++;
                
                if(targetIndex == 0){
                    break;
                }
            }
            else{
                queue.add(queue.poll());
            }
            
            if( targetIndex-1 < 0 ){
                
                targetIndex = queue.size() -1; 
            }
            else{
                targetIndex -= 1;
            }
        }            
        
        return answer;
    }
}
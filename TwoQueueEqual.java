import java.util.*;

class TwoQueueEqual {
    public int TwoQueueEqual(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();
        
        long list1Sum=0;
        long list2Sum=0;
        for(int value: queue1){
            list1.offer(value);
            list1Sum += value;
        }
        for(int value: queue2){
            list2.offer(value);
            list2Sum += value;
        }
        
        long total = queue1.length *2 + queue2.length +1;
        long count =0;
        while(total > count){

            if(list1Sum == list2Sum){
                return answer;
            }
            else if(list1Sum < list2Sum){

                if(list2.size() == 0){
                    return -1;
                }
                int number = list2.peek();
                
                list1.add(number);
                list2.remove();
                list1Sum += number;
                list2Sum -= number;
            }
            else{
                if(list1.size() == 0){
                    return -1;
                }
                int number = list1.peek();

                list2.add(number);
                list1.remove();
                list2Sum += number;
                list1Sum -= number;
                
            }
            answer++;
            
            count++;
        }
        
        if(list1Sum != list2Sum){
            answer = -1;
        }
        
        return answer;
    }
    
    private int sum( Queue<Integer> list ){
        int sum=0;
        
        for(int value : list){
            sum += value;
        }
        return sum;
    }
}
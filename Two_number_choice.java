import java.util.ArrayList;
import java.util.Collections;

class Two_number_choice {
    public int[] Two_number_choice(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!list.contains(numbers[i]+numbers[j])){
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}
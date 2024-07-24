import java.util.*;

public class Hate_equal_number {
    public int[] Hate_equal_number(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int count =0;
        
        for(int j=0;j<arr.length;j++){
            if(list.size()>0){
                if(list.get(count-1)!=arr[j]){
                    list.add(arr[j]);
                    count++;
                }
            }
            else{
                list.add(arr[j]);
                count++;
            }
            
        }

        System.out.println("Hello Java");
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
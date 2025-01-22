import java.util.*;

class BigNumber {
    public String BigNumber(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<numbers.length;i++){
            
            list.add(String.valueOf(numbers[i]));
        }
        
        list.sort( (o1,o2) -> {
            
            String num2 = o1+o2;
            String num1 = o2+o1;
            
            return num1.compareTo(num2);
            
        });
        
        for(int i=0;i<list.size();i++){
            answer += list.get(i);
        }
        
        if(answer.charAt(0)=='0'){
            answer = "0";
        }
        
        return answer;
    }
}
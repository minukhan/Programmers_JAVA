import java.util.*;
class RollCakeCutting {
    public int RollCakeCutting(int[] topping) {
        int answer = 0;
        
        HashMap<Integer,Integer> mapLeft = new HashMap<>();
        HashMap<Integer,Integer> mapRight = new HashMap<>();
        int count=0;
        
        for(int i=0;i<topping.length;i++){
            mapRight.put(topping[i], mapRight.getOrDefault(topping[i], 0) + 1);
        }
        
        
        for(int i=0;i<topping.length;i++){
            mapLeft.put(topping[i], 1);
            
            if(mapRight.get(topping[i]) == 1){
                mapRight.remove(topping[i]);
            } 
            else{
                mapRight.put(topping[i], mapRight.get(topping[i]) -1);
            }
            
            if(mapRight.size() == mapLeft.size()){
                answer++;
            }
            
        }
        
                return answer;
    }
}
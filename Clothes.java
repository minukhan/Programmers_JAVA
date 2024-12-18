import java.util.*;

class Clothes {
    public int Clothes(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String value : map.keySet()){
            answer = answer * (map.get(value) + 1);
        }
        
        return answer-1 ; // 모두 안입는 경우는 제외
    }
}
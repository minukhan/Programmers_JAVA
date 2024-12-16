import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

class tangerine {

    public int tangerine(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //개수 세고 넣는
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int value: map.values()){
            list.add(value);
        }
        
        list.sort(Comparator.reverseOrder());
        
        int sum =0;
        
        for(int i=0;i<list.size();i++){
            if(sum+list.get(i)>=k){
                answer++;
                break;
            }
            sum += list.get(i);
            answer++;
        }
        
        
        
        
        
        
        
        
        
        return answer;
    }
}
import java.util.ArrayList;
import java.util.Arrays;

class LifeBoat {
    public int LifeBoat(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<people.length;i++){
            list.add(people[i]);
        }
        
        int index = 0;
        
        for(int i=list.size()-1;i>=index;i--){
            if(list.get(i) + list.get(index) <= limit){
                index++;
            }
            answer++;
        }
        
        return answer;
    }
}
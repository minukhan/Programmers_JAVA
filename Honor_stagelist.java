import java.util.ArrayList;
import java.util.Collections;

class Honor_stagelist {
    public int[] Honor_stagelist(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int min=2001;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<score.length;i++){
            
            if(list.size()<k){
                list.add(score[i]);
                Collections.sort(list);
                min = list.get(0);
            }
            else if(list.size()==k){
                if(min<score[i]){
                    list.remove(0);
                    list.add(score[i]);
                }
                Collections.sort(list);
                min = list.get(0);
            }
            
            answer[i] = min;
        }
        
        
        return answer;
    }
}
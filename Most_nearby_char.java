import java.util.ArrayList;

class Most_nearby_char {
    public int[] Most_nearby_char(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        
        char word;
        boolean find = false;
        int index=0;
        
        for(int i=0;i<s.length();i++){
            
            word = s.charAt(i);
            
            for(int j=i-1;j>=0;j--){
                index++;
                if(word==s.charAt(j)){
                    find = true;
                    break;
                }
            }
            
            if(find){
                list.add(index);
            }
            else{
                list.add(-1);
            }
            find = false;
            index=0;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
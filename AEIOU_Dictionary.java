import java.util.*;
class AEIOU_Dictionary {
    
    private static char[] wordArray = {'A' ,'E' ,'I' ,'O' ,'U'};
    private static ArrayList<String> list;
    
    public int AEIOU_Dictionary(String word) {
        
        list = new ArrayList<>();
        
        dfs("");

        return list.indexOf(word);
    }
    
    
    private void dfs(String word){
        
        
        
        if(word.length()>5){
            return;
        }
        
        list.add(word);
        
        for(int i=0;i<wordArray.length;i++){
            dfs( word + wordArray[i]);
        }
        
            
    }
    
    
}
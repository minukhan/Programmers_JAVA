import java.util.Arrays;

class Phone_List {
    public boolean Phone_List(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
            for(int j=0;j<phone_book.length-1;j++){
                    if(phone_book[j+1].startsWith(phone_book[j])){
                        answer = false;
                        break;
                    }
            }
        
        return answer;
    }
}

//second Solution

/*
 * import java.util.Arrays;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        StringBuilder sb = new StringBuilder();
        
        for(String value : set){
            
            char[] arr = value.toCharArray();
            
            for(int j=0;j<arr.length-1;j++){
                sb.append(arr[j]);
                
                if(set.contains(sb.toString())){
                    answer = false;
                    break;
                }
                
            }
            sb.delete(0, sb.length());
        }
        
        
        return answer;
    }
}
 */
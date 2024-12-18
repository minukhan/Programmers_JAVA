import java.util.*;

class Cache_Quiz {
    public int Cache_Quiz(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        for(int i=0;i<cities.length;i++){
            
            if(cacheSize==0){
                answer = 5 * cities.length;
                break;
            }
            else if(set.isEmpty()){
                set.add(cities[i]);
                answer+=5;
            }
            else if(set.contains(cities[i])){
                set.remove(cities[i]);
                set.add(cities[i]);
                answer += 1;
                
            }
            else{
                if(set.size()<cacheSize){
                    set.add(cities[i]);
                    answer+=5;
                }
                else{
                    String[] arr = set.toArray(new String[0]);
                    String lastcity = arr[0];
                    
                    set.remove(lastcity);
                    set.add(cities[i]);
                    answer+=5;
                }
            }
                       
        }        
        return answer;
    }
}
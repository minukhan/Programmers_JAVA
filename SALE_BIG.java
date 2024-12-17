import java.util.*;

class SALE_BIG {
    public int SALE_BIG(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int maxLength =0;
        int zero =0;
        boolean finish = true;
        
        // 총 길이
        for(int i=0;i<number.length;i++){
            maxLength += number[i];   
        }
        
        HashMap <String, Integer> map = new HashMap<>();
        
        for(int i=0;i<discount.length;i++){
            
            // 해시 Map 초기화 과정
            for(int k=0;k<want.length;k++){
                map.put(want[k], number[k]);
            }
            
            for(int j=i;j<i + maxLength;j++){
                if(j>=discount.length){
                    break;
                }
                
                if(map.containsKey(discount[j])){
                    map.put(discount[j], map.get(discount[j])-1);
                    
                    finish = true;
                    
                    for(int u=0;u<want.length;u++){
                        if( !(map.get(want[u]) == 0)){
                            finish = false;
                        }
                    }
                    if( finish ){
                        answer++;        
                    }
                }
                
            }
        }
        
        return answer;
    }
}
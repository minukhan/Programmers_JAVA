import java.util.Arrays;

class H_Index {

    public int H_Index(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int count =0;
        int second =0;
        
        for(int i=0;i<citations.length;i++){
            
            count =0;
            
            for(int j=0;j<citations.length;j++){
                if(i<=citations[j]){
                    count++;
                }       
            }
            second =0;
            for(int j=0;j<citations.length;j++){
                if(count<=citations[j]){
                    second++;
                }       
            }
            
            if(second >= count){
                
                answer = Math.max(answer, count);
                
            }
        }
        return answer;
    }
}
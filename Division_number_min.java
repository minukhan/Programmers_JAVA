public class Division_number_min {
    public int Division_number_min(int n) {
        int answer = 0;
        
        for(int i=1;i<n;i++){
            if(n%i==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
} 
    


class divisor {
    public int[] divisor(int n) {
        int k=0;
        
        for(int i=1;i<n+1;i++){
            if(n%i==0){
                k++;
            }
        }
        int[] answer = new int[k];
        
        k=0;
        
        for(int i=1;i<n+1;i++){
            if(n%i==0){
                answer[k]=i;
                k++;
            }
        }
        
        return answer;
    }
}
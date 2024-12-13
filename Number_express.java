class Number_express {
    public int Number_express(int n) {
        int answer =1;
        if(n==1 || n==2){
            answer =0;
        }
        
        int maxif = n/2+1;
        for(int k=1;k<=maxif;k++){
            
            int sum = 0;
            
            for(int i=k;i<=maxif;i++){
                sum+=i;
                
                if(sum==n){
                    answer++;
                }
                if(sum>n){
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}
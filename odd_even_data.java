class odd_even_data {
    public int odd_even_data(int n) {
        int answer = 0;
        
        if(n%2==0){
            for(int i=0;i<n+1;i++){
                if(i%2==0){
                    answer = answer+ i*i;
                }
            }
        }
        else{
            for(int i=0;i<n+1;i++){
                if(i%2==1){
                    answer = answer+i;
                }
            }
        }
        
        return answer;
    }
}
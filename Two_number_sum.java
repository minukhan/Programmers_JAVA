class Two_number_sum {
    public long Two_number_sum(int a, int b) {
        long answer = 0;
        int temp=0;
        
        if(a>b){
            temp = a;
            a = b;
            b = temp;
        }
        
        for(int i=a;i<b+1;i++){
            answer += i;
            
        }
        return answer;
    }
}
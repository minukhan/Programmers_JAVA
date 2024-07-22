class Col_predict {
    public int Col_predict(int num) {
        int answer = -1;
        int count=1;
        
        while(count<502){
            if(num==1){
                answer = 0;
                break;
            }
            
            if(num%2==0){
                num=num/2;
            }
            else if(num%2==1){
                num = num*3 +1;
            }
            
            if(num==1){
                answer = count;
                break;
            }
            count++;
        }
        
        return answer;
    }
}
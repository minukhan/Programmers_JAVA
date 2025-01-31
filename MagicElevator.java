class MagicElevator {
    public int MagicElevator(int storey) {
        int answer = 0;
        
        while(storey!=0){
            
            int remain = storey%10;
            int nextRemain = (storey/10) % 10;
            
            if(storey < 10){
                if(remain<=5){
                    answer += remain;
                    storey = storey/10;
                }
                else if(remain>5){
                    answer += 10 - remain;
                    storey = storey/10 + 1;
                } 
            }
            else{
                if(remain<5){
                    answer += remain;
                    storey = storey/10;
                }
                else if(remain>5){
                    answer += 10 - remain;
                    storey = storey/10 + 1;
                }
                else if(remain == 5){

                    if(nextRemain<5){
                        answer += remain;
                        storey = storey/10;
                    }
                    else{
                        answer += 10 - remain;
                        storey = storey/10 + 1;
                    }
                }
            }
            
            
        }
        
        return answer;
    }
}
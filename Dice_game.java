class Dice_game {
    public int Dice_game(int a, int b, int c, int d) {
        int answer = 0;
        
        int[] arr ={0,0,0,0,0,0,0};
        arr[a]++;
        arr[b]++;
        arr[c]++;
        arr[d]++;
        int count =0;
        boolean three=false;
        int threenum =0;
        int one =0;

        for(int i=0;i<7;i++){
            if(arr[i]!=0){
                count++;
            }
            if(arr[i]==3){
                three=true;
                threenum=i;
            }
            
        }
        if(count==4){
            for(int i=0;i<7;i++){
                if(arr[i]!=0){
                    answer = i;
                    break;
                }    
            }
        }
        else if(count==1){
            answer = a*1111;
        }
        else if(count==3){
            answer =1;
            for(int i=0;i<7;i++){
                if(arr[i]==1){
                    answer *= i;
                }    
            }
        }
        else if(count==2){
            if(three){
                for(int i=0;i<7;i++){
                    if(arr[i]==1){
                        one = i;
                    }
                }
                answer = (threenum*10 + one) * (threenum*10 + one);
            }
            else{
                if(a==b){
                    answer = (a+c) * (Math.abs(a-c));
                }
                else if(a==c){
                    answer = (a+b) * (Math.abs(a-b));
                    
                }
                else{
                    answer = (a+c) * (Math.abs(a-c));
                    
                }
            }
        }
        
        
        
        return answer;
    }
}
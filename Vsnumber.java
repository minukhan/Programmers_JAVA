class Vsnumber {
    public int Vsnumber(int a, int b) {
        int answer = 0;
        
        int connecta=0;
        int connectb=0;
        int temp =0;
        
        for(int i=0;i<2;i++){
            
            if(i==0){
                if(b>1000){
                    connecta = a*10000+b;
                }
                else if(b>100){
                    connecta = a*1000 +b;
                }
                else if(b>10){
                    connecta = a*100 +b;
                }
                else{
                    connecta = a*10 +b;
                }
            }
            else{
                temp =a;
                a=b;
                b=temp;
                if(b>1000){
                    connectb = a*10000+b;
                }
                else if(b>100){
                    connectb = a*1000 +b;
                }
                else if(b>10){
                    connectb = a*100 +b;
                }
                else{
                    connectb = a*10 +b;
                }
            }
        }
        
        
        if(connecta>connectb){
            answer = connecta;
        }
        else{
            answer = connectb;
        }
        
        
        return answer;
    }
}
class compare_number {
    public int compare_number(int a, int b) {
        int answer = 0;
        int connect=0;
        
        if(b>1000){
            connect = a*10000+b;
        }
        else if(b>100){
            connect = a*1000 +b;
        }
        else if(b>10){
            connect = a*100 +b;
        }
        else{
            connect = a*10 +b;
        }
        
        if(connect>2*a*b){
            answer = connect;
        }
        else{
            answer = 2*a*b;
        }
        
        return answer;
    }
}
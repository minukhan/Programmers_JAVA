class finite_decimal {
    public int finite_decimal(int a, int b) {
        int answer = 2;
        int num =0;
        
        while(b>1){
            if(b%2==0){
                b = b/2;
            }
            else if(b%5==0){
                b = b/5;
            }
            else{
                if(b>1){
                    num = b;
                    break;
                }
            }
        }
        
        if(a%b==0){
            answer = 1;
        }

        return answer;
    }
}
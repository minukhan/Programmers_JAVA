class change_money {
    public long change_money(int price, int money, int count) {
        long answer = 0;
        long num=money;
        
        for(int i=0;i<count;i++){
            num= num - price*(i+1);
        }
        
        if(num>=0){
            return 0;
        }
        else{
            answer = (long)(Math.abs(num));
        
            return answer;
        }
        
        
    }
}

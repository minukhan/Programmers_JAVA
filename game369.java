class game369 {
    public int game369(int order) {
        int answer = 0;
        int le;
        
        for(int i=0;i<8;i++){
            if(order==0){
                break;
            }
            
            le = order%10;
            
            if(le==3 || le==6 || le==9){
                answer++;
            }
            
            order= order/10;
        }
        return answer;
    }
}
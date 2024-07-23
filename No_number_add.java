class No_number_add {
    public int No_number_add(int[] numbers) {
        int answer = 0;
        boolean num =false;
        
        for(int i=1;i<10;i++){
            for(int j=0;j<numbers.length;j++){
                if(i==numbers[j]){
                    num = true;
                }
            }
            
            if(!num){
                answer+=i;
            }
            
            num = false;
        }
        
        
        return answer;
    }
}
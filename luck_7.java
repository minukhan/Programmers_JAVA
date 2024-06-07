class luck_7 {
    public int luck_7(int[] array) {
        int answer = 0;
        
        for(int i=0;i<array.length;i++){
            while(array[i]>0){
                if(array[i]%10==7){
                    answer++;
                }
                array[i] = array[i]/10;
            }
        }
        
        return answer;
    }
}
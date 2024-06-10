class MaxMake {
    public int MaxMake(int[] numbers) {
        int answer = 0;
        int max = -10001;
        int change=0;
        int maxindex=0;
        
        
        for(int i=0;i<numbers.length;i++){
            
            max =-10001;
            maxindex = 0;
            
            for(int j=0;j<numbers.length-i;j++){
                if(max<numbers[j]){
                    max = numbers[j];
                    maxindex = j;
                }
            }
            change = numbers[numbers.length-1-i];
            numbers[numbers.length-1-i] = numbers[maxindex];
            numbers[maxindex] = change;
        }
        
        answer = numbers[numbers.length-1] * numbers[numbers.length-2];
        
        if(answer < (numbers[0] * numbers[1])) answer =numbers[0] * numbers[1];
        
        return answer;
    }
}
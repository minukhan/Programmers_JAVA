class ballthrow {
    public int ballthrow(int[] numbers, int k) {
        int answer = 0;
        int count=0;
        
        count = 2*(k-1);
        
        while(count >= numbers.length){
            count = count - numbers.length;
        }
        answer = numbers[count];
        
        
        return answer;
    }
}
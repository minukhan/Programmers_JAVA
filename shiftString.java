class shiftString {
    public int[] shiftString(int[] numbers, String direction) {
        int[] answer = {};
        int change =0;
        
        if(direction.equals("right")){
            change=numbers[numbers.length-1];
        
            for(int i=numbers.length-1;i>0;i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = change;
        }
        if(direction.equals("left")){
            change=numbers[0];
        
            for(int i=1;i<numbers.length;i++){

                numbers[i-1] = numbers[i];
            }
            numbers[numbers.length-1] = change;
        }
        
        return numbers;
    }
}
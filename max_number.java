class max_number {
    public int[] max_number(int[] array) {
        
        int[] answer = new int[2];
        
        int max = 0;
        int max_index =0;
        
        
        for (int i=0;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
                max_index = i;
            }
        }
        
        answer[0] = max;
        answer[1] = max_index;
        
        
        return answer;
    }
}
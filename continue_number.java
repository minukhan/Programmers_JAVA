class continue_number {
    public int[] continue_number(int num, int total) {
        int[] answer = new int[num];
        int first = (total-(num-1)*(num)/2)/num;
        
        for(int i=0;i<num;i++){
            answer[i] = first;
            first++;
        };
        
        return answer;
    }
}
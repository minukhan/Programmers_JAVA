class Count_array {
    public int[] Count_array(int[] num_list, int n) {
        int[] answer = new int[n];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = num_list[i];
        }
        return answer;
    }
}
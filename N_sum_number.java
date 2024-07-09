class N_sum_number {
    public int N_sum_number(int[] numbers, int n) {
        int answer = 0;
        int i=0;
        while(answer<=n){
            answer+=numbers[i];
            i++;
        }
        
        return answer;
    }
}
class cola_question {
    public int cola_question(int a, int b, int n) {
        int answer = 0;
        int empty =n;
        
        while(empty>=a){
            answer += empty/a* b; 
            empty = empty%a + empty/a * b; 
        }
        
        return answer;
    }
}
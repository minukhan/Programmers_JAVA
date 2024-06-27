class next_number {
    public int next_number(int[] common) {
        int answer = 0;
        
        if((common[2]-common[1]) == (common[1]-common[0])){
                answer = common[common.length-1] + common[2]-common[1];
        }
        else{
            answer = common[common.length-1] * (common[common.length-1]/common[common.length-2]);
        }
        
        return answer;
    }
}


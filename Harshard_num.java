class Harshard_num {
    public boolean Harshard_num(int x) {
        boolean answer = true;
        String num = String.valueOf(x);
        int sum = 0;
        
        for(int i=0;i<num.length();i++){
            sum += num.charAt(i)-'0';
        }
        if(x%sum!=0){
            answer = false;
        }
        
        
        return answer;
    }
}
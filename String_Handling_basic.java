class String_Handling_basic {
    public boolean String_Handling_basic(String s) {
        boolean answer = true;
        
        if(s.length()==4 || s.length()==6){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)-'0'>10){
                    answer = false;
                }
            }
        }
        else{
            answer = false;
        }
        
        
        return answer;
    }
}
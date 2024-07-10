class String_reverse {
    public String String_reverse(String my_string, int s, int e) {
        String answer = "";
        String reverse = "";
        
        for(int i=e;i>=s;i--){
            reverse += my_string.charAt(i);
        }
        for(int i=s;i<e+1;i++){
            answer += my_string.charAt(i);
        }        
        my_string = my_string.replace(answer,reverse);
        answer="";
        for(int i=0;i<my_string.length();i++){
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}
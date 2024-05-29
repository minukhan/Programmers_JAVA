class change_char {
    public String change_char(String my_string, int num1, int num2) {
        String answer = "";
        char[] change = my_string.toCharArray();
        char ch;
        
        ch = change[num1];
        change[num1]=change[num2];
        change[num2]=ch;
        
        for(int i=0;i<change.length;i++){
            answer = answer+change[i];
        }
        
        return answer;
    }
}
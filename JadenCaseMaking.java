class JadenCaseMaking {
    public String JadenCaseMaking(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        char currentChar;
        boolean checkFirst = true;
        
        for(int i=0;i<s.length();i++){
            currentChar = s.charAt(i);
            
            if(currentChar==' '){
                sb.append(currentChar);
                checkFirst = true;
            }
            else if(checkFirst){
                sb.append(Character.toUpperCase(currentChar));
                checkFirst = false;
            }
            else{
                sb.append(Character.toLowerCase(currentChar));
            }
        }
       
        answer = sb.toString();
        
        return answer;
    }
}
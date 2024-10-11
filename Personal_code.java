class Personal_code {
    public String Personal_code(String s, String skip, int index) {
        
        String answer = "";
        char[] skipArray = new char[skip.length()];
        char[] sArray = new char[s.length()];
        int skipcount =5;
        
        for(int i=0;i<skip.length();i++){
            skipArray[i] = skip.charAt(i);
        }
        for(int i=0;i<s.length();i++){
            sArray[i] = s.charAt(i);
        }
        
        for(int i=0;i<s.length();i++){
            skipcount =index;
            while(skipcount>0){
                
                if(sArray[i]=='z'){
                    sArray[i] = 'a';
                }
                else{
                    sArray[i] += 1;
                }
                skipcount--;
                
                for(int j=0;j<skip.length();j++){
                    if(sArray[i] == skipArray[j]){
                        skipcount++;
                    }
                }
            }
            answer+= sArray[i];
            
        }
        
        return answer;
    }
}
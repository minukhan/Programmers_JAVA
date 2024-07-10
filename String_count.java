class String_count {
    public int String_count(String myString, String pat) {
        int answer = 0;
        String count="";
        
        for(int i=0;i<myString.length();i++){
            for(int j=i;j<pat.length()+i;j++){
                
                if(j>myString.length()-1){
                    break;
                }
                count += myString.charAt(j);
            }
            if(count.equals(pat)){
                answer++;
            }
            count = "";
        }
        
        return answer;
    }
}
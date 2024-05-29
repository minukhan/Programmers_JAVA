class charinclude {
    public int charinclude(String str1, String str2) {
        int answer = 2;
        String ans = "";
        int k=0;
        char[] com = str1.toCharArray();
        char[] com2 = str2.toCharArray();
        
        for (int i=0;i<str1.length();i++){
            if(com[i]==com2[0]){
                k=i;
                for(int j=0;j<str2.length();j++){
                    
                    ans = ans+com[k];
                    k++;
                    
                    if(k>=str1.length()){
                        break;
                    }
                }
                
                if(ans.equals(str2)){
                    answer = 1;
                    break;
                }
                ans="";
            }
        }
        return answer;
    }
}
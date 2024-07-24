class Strange_number {
    public String Strange_number(String s) {
        String answer = "";
        char[] S;
        
        String[] arr = s.split(" ",-1);
        
        for(int i=0;i<arr.length;i++){
            S = arr[i].toCharArray();
            
            for(int j=0;j<S.length;j++){
                
                if(j%2==0){
                    S[j] = Character.toUpperCase(S[j]);
                }
                else{
                    S[j] = Character.toLowerCase(S[j]);
                }
            }
            
            for(int k=0;k<S.length;k++){
                answer += S[k];
            }
            
            if(i!=arr.length-1){
                answer+=" ";
            }
            
        }
        
        
                
        return answer;
    }
}
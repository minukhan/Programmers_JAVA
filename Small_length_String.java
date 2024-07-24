class Small_length_String {
    public int Small_length_String(String t, String p) {
        int answer = 0;
        String compare = "";
        
        for(int i=0;i<t.length()-p.length()+1;i++){
            for(int j=i;j<p.length()+i;j++){
                compare += t.charAt(j);
            }
            
            for(int k=0;k<p.length();){
                
                if(compare.charAt(k)-'0' < p.charAt(k)-'0'){
                    answer++;
                    break;
                }
                else if(compare.charAt(k)-'0' > p.charAt(k)-'0'){
                    break;
                }
                else{
                    k++;
                    if(k==p.length()){
                        answer++;
                        break;
                    }
                    
                }
            }
            
            compare ="";
            
        }
        
        return answer;
    }
}
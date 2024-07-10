
class Partial_string {
    public String Partial_string(String myString, String pat) {
        String answer = "";
        int index =0 ;
        
        for(int i=myString.length()-1;i>=0;i--){
            
            if(pat.charAt(0)==myString.charAt(i)){
                
                index=i;
                while(i+pat.length()>index){
                    if(i+pat.length()>myString.length()){
                        break;
                    }
                    answer +=myString.charAt(index);
                    index++;
                }
                
                if(answer.equals(pat)){
                    answer ="";
                    
                    for(int j=0;j<index;j++){
                        answer += myString.charAt(j);
                    }
                    break;
                }
                answer ="";
                
            }
        }
        return answer;
    }
}
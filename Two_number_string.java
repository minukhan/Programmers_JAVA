class Two_number_string {
    public String Two_number_string(String a, String b) {
        String answer = "";
        String answer_re="";
        int len = 0;
        int anum =0;
        int bnum =0;
        boolean alen= false;
        int plus=0;
        
        if(a.length()>b.length()){
            len = a.length();
            alen=true;
        }
        else{
            len = b.length();
        }
        
        for(int i=0;i<len;i++){
              
            if(alen){
                if(i>=b.length()){
                    anum = a.charAt(a.length()-i-1)-'0';
                    if(anum+plus==10){
                        answer+= 0;
                        plus=1;
                    }
                    else{
                        answer+= anum+plus;
                        plus=0;
                    }
                }
                else{
                    anum = a.charAt(a.length()-i-1)-'0';
                    bnum = b.charAt(b.length()-i-1)-'0';
                    if(anum+bnum+plus>=10){
                        answer+= (anum+bnum+plus)%10;
                        plus=0;
                        plus++;
                    }
                    else{
                        answer+= anum+bnum +plus;
                        plus=0;
                    }
                    
                    if(plus!=0 && i==a.length()-1){
                        answer += plus;
                        plus=0;
                    }
                }
                
            }
            else{
                if(i>=a.length()){
                    bnum = b.charAt(b.length()-i-1)-'0';
                    if(bnum+plus==10){
                        answer+= 0;
                        plus=1;
                    }
                    else{
                        answer+= bnum+plus;
                        plus=0;
                    }
                }
                else{
                    anum = a.charAt(a.length()-i-1)-'0';
                    bnum = b.charAt(b.length()-i-1)-'0';
                    if(anum+bnum+plus>=10){
                        answer+= (anum+bnum+plus)%10;
                        plus=0;
                        plus++;
                    }
                    else{
                        answer+= anum+bnum +plus;
                        plus=0;
                    }
                    
                    if(plus!=0 && i==b.length()-1){
                        answer += plus;
                        plus=0;
                    }
                }
                
            }
        }
        
        if(plus==1){
            answer+=1;
        }
        
        
        for(int i=0;i<answer.length();i++){
            answer_re+= answer.charAt(answer.length()-i-1);
        }
        
        return answer_re;
    }
}
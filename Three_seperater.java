class Three_seperater {
    public String[] Three_seperater(String myStr) {
        String abc ="";
        int count=0;
        for(int i=0;i<myStr.length();i++){
            
            if(myStr.charAt(i)=='a' || myStr.charAt(i)=='b' || myStr.charAt(i)=='c'){
                if(abc!=""){
                    count++;
                }
                abc = "";
            }
            else{
                abc += myStr.charAt(i);
                if(i==myStr.length()-1){
                    count++;
                }
            }
        }
        abc="";
        
        if(count==0){
            String[] answer = new String[1];
            
            answer[0] = "EMPTY";
            return answer;
        }
        else{
            String[] answer = new String[count];
            count=0;
        
            for(int i=0;i<myStr.length();i++){
                if(myStr.charAt(i)=='a' || myStr.charAt(i)=='b' || myStr.charAt(i)=='c'){
                    if(abc!=""){
                        answer[count++] = abc;
                    }
                    abc = "";
                }
                else{
                    abc += myStr.charAt(i);
                    if(i==myStr.length()-1){
                        if(abc!=""){
                            answer[count++] = abc;
                        }
                    }
                }
            }
            return answer;
        }
        
        
    }
}
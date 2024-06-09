class cut_array {
    public String[] cut_array(String my_str, int n) {
        String[] answer;
        int count=0;
        String str="";
        
        int len = my_str.length();
        if(len%n==0){
            answer = new String[len/n];
            count = len/n;    
        }
        else{
            answer = new String[len/n+1];
            count = len/n+1;
        }
        int k=0;
        
        for(int i=0;i<count;i++){
            for(int j=0;j<n;j++){
                if(k==len){
                    break;
                }
                str += my_str.charAt(k);
                k++;
            }
            answer[i] = str;
            str="";
        }
            
            
        
        return answer;
    }
}
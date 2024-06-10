class char_duplicate {
    public String char_duplicate(String my_string) {
        String answer = "";
        int k=0;
        boolean tee = false;
            
        char[] arr = new char[my_string.length()];
        for(int i=0;i<my_string.length();i++){
            
            for(int j=0;j<my_string.length();j++){
                if(arr[j]==my_string.charAt(i)){
                    System.out.print("count");
                    tee = true;
                }
         
            }
            if(!tee){
                arr[k] = my_string.charAt(i);
                answer += my_string.charAt(i);
                k++;
            }
            
            
            tee = false;
  
        }
        

        
        
        return answer;
    }
}
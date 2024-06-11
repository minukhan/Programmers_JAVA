class deletechar {
    public String deletechar(String my_string, String letter) {

        
        char[] test = new char[my_string.length()];
        char[] test2 = new char[my_string.length()];
        char mess = letter.charAt(0);
        int k =0;
        
        
        test = my_string.toCharArray();
        
        for(int i=0;i<my_string.length();i++){
            if(test[i]!=mess){
                
                test2[k] = test[i];
                k++;
            }
        }
        
        String answer = new String(test2 ,0, k);
        
        return answer;
    }
}


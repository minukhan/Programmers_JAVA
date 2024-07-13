class Right_left_array {
    public String[] Right_left_array(String[] str_list) {
        String L_R=""; 
        
        for(int i=0;i<str_list.length;i++){
            if(str_list[i].equals("l")){
                for(int j=0;j<i;j++){
                    L_R+=str_list[j];
                    L_R+=" ";
                }
                break;
            }
            else if(str_list[i].equals("r")){
                for(int j=i+1;j<str_list.length;j++){
                    L_R+=str_list[j];
                    L_R+=" ";
                }
                break;
            }
        }
        if(L_R.equals("")){
            String[] answer = new String[0];   
            return answer;
        }
        else{
            String[] answer = L_R.split(" ");
            return answer;
        }
        
        
    }
}
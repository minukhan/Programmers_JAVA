class Blind_Phone_number {
    public String Blind_Phone_number(String phone_number) {
        String answer = "";
        
        for(int i=0;i<phone_number.length();i++){
            if(i+4>=phone_number.length()){
                answer+=phone_number.charAt(i);
            }
            else{
                answer+="*";
            }
        }
        return answer;
    }
}
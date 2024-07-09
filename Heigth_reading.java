class Heigth_reading {
    public String Heigth_reading(String my_string, int m, int c) {
        String answer = "";
        
        for(int i=c-1;i<my_string.length();i=i+m){
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}
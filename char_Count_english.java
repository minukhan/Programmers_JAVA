class char_Count_english {
    public int[] char_Count_english(String my_string) {
        int[] answer = new int[52];
        
        for(int i=0;i<my_string.length();i++){
            if((int)my_string.charAt(i)>96){
                answer[(int)my_string.charAt(i)-71]++;
            }
            else{
                answer[(int)my_string.charAt(i)-65]++;
            }
        }
        
        return answer;
    }
}
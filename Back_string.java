class Back_string {
    public int Back_string(String my_string, String is_suffix) {
        int answer = 0;
        char[] arr = my_string.toCharArray();
        String back="";
        
        for(int j=0;j<my_string.length();j++){
            for(int i=arr.length-1-j;i<arr.length;i++){
                back += arr[i]; 
            }
            if(back.equals(is_suffix)){
                answer = 1;
            }
            
            back="";
        }

        return answer;
    }
}


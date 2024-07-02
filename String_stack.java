class String_stack {
    public String String_stack(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        char[] arr = my_string.toCharArray();
        
        for(int i=s;i<overwrite_string.length()+s;i++){
            arr[i] = overwrite_string.charAt(i-s);
        }
        
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        
        return answer;
    }
}
class String_arraychar {
    public String String_arraychar(String[] arr) {
        String answer = "";
        
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        return answer;
    }
}
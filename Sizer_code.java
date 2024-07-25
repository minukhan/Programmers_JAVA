class Sizer_code {
    public String Sizer_code(String s, int n) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            
            if(Character.isUpperCase(arr[i])){
                arr[i] = (char)((arr[i]-'A' + n) % 26 + 'A'); 
            }
            else if(Character.isLowerCase(arr[i])){
                arr[i] = (char)((arr[i]-'a' + n) % 26 + 'a'); 
            }
        }
        
        for(int i=0;i<arr.length;i++){
            answer+= arr[i];
        }
        
        return answer;
    }
}
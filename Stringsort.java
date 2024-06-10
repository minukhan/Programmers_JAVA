class Stringsort {
    public String Stringsort(String my_string) {
        String answer = "";
        int[] ascii = new int[my_string.length()];
        char[] arr = new char[my_string.length()];
        int max=0;
        int len=my_string.length();
        int chagne=0;
        
        arr = my_string.toCharArray();

        for(int i=0;i<len;i++){ //문자열의 대문자를 소문자로 바꾸는 코드
            
            
            ascii[i] = arr[i];
            
            if(ascii[i]<91){
                ascii[i] +=32;
            }
            
        }
        
        for(int i=0;i<len;i++){ //순서대로 정렬을 시켰다.
            for(int j=1;j<len-i;j++){
                
                if(ascii[j-1]>ascii[j]){
                    chagne = ascii[j-1];
                    ascii[j-1] =ascii[j];
                    ascii[j]=chagne;
                }
                
            }
        }
        for(int i=0;i<len;i++){
            arr[i] = (char)ascii[i];
            answer += arr[i];
        }
        
        
        
        return answer;
    }
}
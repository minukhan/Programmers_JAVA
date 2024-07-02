class AB_reverse {
    public int AB_reverse(String myString, String pat) {
        int answer = 0;
        String reverse="";
        
        char[] arr = myString.toCharArray();
        
        for(int i=0;i<myString.length();i++){
            if(arr[i]=='A'){
                arr[i] = 'B';
            }
            else{
                arr[i] = 'A';
            }
            reverse += arr[i];
        }
        
        if(reverse.contains(pat)){
            answer=1;
        }
        
        return answer;
    }
}
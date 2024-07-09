class Division_nine {
    public int Division_nine(String number) {
        int answer=0;
        
        number.replace("9","0");
        
        char[] arr = number.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            answer += arr[i] -'0';
        }
        
        
        return answer % 9 ;
    }
}
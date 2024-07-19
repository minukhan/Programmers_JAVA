class Reverse_Number {
    public int[] Reverse_Number(long n) {

        String number = String.valueOf(n);
        
        int[] answer = new int[number.length()];
        
        for(int i=0;i<number.length();i++){
            answer[i] = number.charAt(number.length()-i-1) - '0';
        }
        
        
        return answer;
    }
}
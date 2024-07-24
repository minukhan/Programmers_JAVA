class ternary_scale {
    public int ternary_scale(int n) {
        int answer = 0;
        String number ="";
        int count=1;
        
        while(n>0){
            number += n%3;
            n= n/3;
        }
        
        for(int i=number.length()-2;i>=0;i--){
            answer += 3*(count)*(number.charAt(i)-'0');
            count*=3;
        }
        answer+= number.charAt(number.length()-1)-'0';
        
        return answer;
    }
}
class String_hap {
    public int String_hap(String num_str) {
        int answer = 0;
        
        // integer.parseInt() 메서드는 String 형식만 가능하다.
        // char 형식에서 integer 형식으로 바꾸고 싶다면 -'0' 을 사용해보자.
        
        
        for(int i=0;i<num_str.length();i++){
            answer += num_str.charAt(i)-'0';
        }
        return answer;
    }
}
class number_control {
    public int number_control(int n, String control) {
        int answer = 0;
        
        for(int i=0;i<control.length();i++){
            if(control.charAt(i)=='w'){
                n++;
            }
            else if(control.charAt(i)=='s'){
                n--;
            }
            else if(control.charAt(i)=='d'){
                n = n+10;
            }
            else if(control.charAt(i)=='a'){
                n= n-10;
            }
        }
        answer =n;
        
        return answer;
    }
}
class Make_array5 {
    public int[] Make_array5(String[] intStrs, int k, int s, int l) {
        String number = "";
        int count =0;
        
        for(int j=0;j<intStrs.length;j++){
            for(int i=s;i<l+s;i++){
                number+= intStrs[j].charAt(i);
            }
            
            if(k<Integer.parseInt(number)){
                count++;
            }
            number="";
        }
        int[] answer = new int[count];
        count=0;
        for(int j=0;j<intStrs.length;j++){
            for(int i=s;i<l+s;i++){
                number+= intStrs[j].charAt(i);
            }
            
            if(k<Integer.parseInt(number)){
                answer[count++] = Integer.parseInt(number);
            }
            
            number="";
            
        }
        
        return answer;
    }
}
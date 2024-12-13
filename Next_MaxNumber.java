class Next_MaxNumber {
    public int Next_MaxNumber(int n) {
        int answer = 0;
        
        String Startnumber = Integer.toBinaryString(n);
        int StartCount=0;
        
        for(int j=0;j<Startnumber.length();j++){
                if(Startnumber.charAt(j)=='1'){
                    StartCount++;
                }
        }
        
        for(int i=n+1;i<1000000;i++){
            String number = Integer.toBinaryString(i);
            int count =0;

            for(int j=0;j<number.length();j++){
                if(number.charAt(j)=='1'){
                    count++;
                }
            }
            
            if(StartCount == count){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
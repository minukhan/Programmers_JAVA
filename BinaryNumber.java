class BinaryNumber {
    public int[] BinaryNumber(String s) {
        
        int deleteZero =0;
        int count =0;
        String nextString = "";
        int number =5;
        
        while(s.length()!=1){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    deleteZero++;
                }else{
                    nextString += s.charAt(i);
                }
            }
            s = Integer.toBinaryString(nextString.length());
            
            count++;
            number--;
            nextString ="";
        }
        int[] answer = {count,deleteZero};
        
        return answer;
        
    }
    
    
    private String SecondNumber(int length){
        
        int rest = 0;
        String ChangeNumber ="";
        
        while(length>0){
            
            rest = length % 2;
            length = length / 2;

            ChangeNumber = "" + rest + ChangeNumber;    
            
        }
        
        return ChangeNumber;
    }
}
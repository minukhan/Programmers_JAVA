class P_Y_count {
    boolean P_Y_count(String s) {
        boolean answer = true;
        int pcount=0;
        int ycount=0;
        
        s  = s.toLowerCase();
        
        
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'){
                pcount++;
            }
            else if(s.charAt(i)=='y'){
                ycount++;
            }
        }
        
        if(pcount!=ycount){
            answer = false;
        }
        
        return answer;
    }
}
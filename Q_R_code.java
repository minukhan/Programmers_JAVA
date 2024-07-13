class Q_R_code {
    public String Q_R_code(int q, int r, String code) {
        String answer = "";
        
        for(int i=0;i<code.length();i++){
            if(i%q==r){
                answer+=code.charAt(i);
            }
        }
        
        return answer;
    }
}
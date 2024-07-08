class IfString {
    public int IfString(String ineq, String eq, int n, int m) {
        int answer = 0;
        boolean k = false;
        
        if(ineq.equals(">")){
            if(eq.equals("=")){
                k= n>=m;
            }
            else{
                k = n>m;
            }
        }
        else{
            if(eq.equals("=")){
                k= n<=m;
            }
            else{
                k = n<m;
            }
        }
        
        if(k){
            answer = 1;
        }
        
        return answer;
    }
}
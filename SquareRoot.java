class SquareRoot {
    public long SquareRoot(long n) {
        long answer = 0;
        boolean big=true;
        
        for(long i=0;;i++){
            if(i*i>n){
                answer = -1;
                break;
            }
            
            if(i*i==n){
                answer = (i+1) * (i+1);
                break;
            }
        }
        
        return answer;
    }
}
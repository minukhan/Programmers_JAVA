class fac {
    public int fac(int n) {
        int answer = 0;
        int fac=1;
        int i;
        int j;
            
        for(i=1;i<=n+1;i++){
            for(j=1;j<=i;j++){
                fac = fac*j;
            }
            if(n==1){
                answer = i;
                break;
            }
            if(n<fac){
                answer = i-1;
                break;
            }
            fac =1;
        }
        return answer;
    }
}
class Moduler_Math {
    public int Moduler_Math(int n) {
        int answer = 0;
        
        int first =0;
        int second = 1;
        int temp=0;
        
        for(int i=2;i<=n;i++){
            temp = second%1234567;
            second = (first%1234567+ second%1234567) %1234567;
            first = temp%1234567;
        }
        answer = second%1234567;
        
        return answer;
    }
}
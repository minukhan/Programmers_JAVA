class Long_Jump {
    public long Long_Jump(int n) {
        long answer = 0;
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        
        if(n>=2){
            dp[2] = 2;
        }
        
        for(int i=2;i<dp.length-1;i++){
            dp[i+1] =( dp[i-1] + dp[i] ) % 1234567;
        }
        
        answer = dp[n];
        
        return answer;
    }
}
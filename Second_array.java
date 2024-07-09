class Second_array {
    public int[][] Second_array(int n) {
        int[][] answer = new int[n][n];
        
        for(int i=0;i<n;i++){
            answer[i][i] = 1;
        }
        
        return answer;
    }
}
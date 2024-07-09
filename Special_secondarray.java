class Special_secondarray {
    public int Special_secondarray(int[][] arr) {
        int answer = 1;
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] != arr[j][i]){
                    answer =0;
                }
            }
        }
        return answer;
    }
}
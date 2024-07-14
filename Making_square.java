class Making_square {
    public int[][] Making_square(int[][] arr) {
        
        int max = 0;
        
        if(arr.length>arr[0].length){
            max= arr.length;
        }
        else{
            max = arr[0].length;
        }
        
        int[][] answer = new int[max][max];
        
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                answer[i][j] = arr[i][j];
            }
        }
        
        
        return answer;
    }
}
class overlap_number {
    public int overlap_number(int[][] lines) {
        int answer = 0;
        int[] arr = new int[201];
        

        for(int i=0;i<lines.length;i++){
            for(int k=lines[i][0];k<lines[i][1];k++){
                arr[k+100]++;
            }
            
        }
        
        for(int i=0;i<201;i++){
            if(arr[i]>1){
                answer++;
            }
        }
        
        
        return answer;
    }
}
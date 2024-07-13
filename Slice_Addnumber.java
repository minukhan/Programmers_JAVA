class Slice_Addnumber {
    public int[] Slice_Addnumber(int[] arr, int[][] queries) {
        
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<=queries[i][1];j++){
                if(j%queries[i][2]==0){
                    arr[j]++;
                }
            }
        }
        
        int[] answer = arr;
        
        
        return answer;
    }
}
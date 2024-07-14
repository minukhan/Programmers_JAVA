class Array_Slice {
    public int[] Array_Slice(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int min=10000001;
        int count =0;
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<queries[i][1]+1;j++){
                if(arr[j]>queries[i][2]){
                    if(min>arr[j]){
                        min=arr[j];
                    }
                }
            }

            if(min==10000001){
                answer[count++] = -1;
            }
            else{
                answer[count++] = min;
            }
            
            min=10000001;
            
        }
        
        
        
        return answer;
    }
}
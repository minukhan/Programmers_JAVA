class Add_array {
    public int[] Add_array(int[] arr, int[][] queries) {
        
        for(int j=0;j<queries.length;j++){
            for(int i=queries[j][0];i<=queries[j][1];i++){
                arr[i]++;
            }
        }
        return arr;
    }
}
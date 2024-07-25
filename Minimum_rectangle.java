class Minimum_rectangle {
    public int Minimum_rectangle(int[][] sizes) {
        int answer = 0;
        
        int[][] arr = new int[sizes.length][2];
        
        for(int i=0;i<arr.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                arr[i][0] = sizes[i][0];
                arr[i][1] = sizes[i][1];
            }
            else{
                arr[i][0] = sizes[i][1];
                arr[i][1] = sizes[i][0];         
            }
        }
        int max1=0;
        int max2=0;
        
        for(int i=0;i<arr.length;i++){
            if(max1<arr[i][0]){
                max1 = arr[i][0];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(max2<arr[i][1]){
                max2 = arr[i][1];
            }
        }
        answer = max1 * max2;
        return answer;
    }
}
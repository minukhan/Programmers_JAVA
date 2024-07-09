
class Array_Making3 {
    public int[] Array_Making3(int[] arr, int[][] intervals) {
        
        int count=0;
        
        for(int i=0;i<intervals.length;i++){
            for(int j=intervals[i][0];j<=intervals[i][1];j++){
                count++;
            }
        }
        
        int[] answer = new int[count];
        count=0;
        for(int i=0;i<intervals.length;i++){
            for(int j=intervals[i][0];j<=intervals[i][1];j++){
                answer[count++] = arr[j];
            }
        }
        
        return answer;
    }
}
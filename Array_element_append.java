class Array_element_append {
    public int[] Array_element_append(int[] arr) {
        int count =0;
        
        for(int i=0;i<arr.length;i++){
            count += arr[i];
        }
        
        int[] answer = new int[count];
        count =0;
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=0;j<arr[i];j++){
                answer[count] = arr[i];
                count++;
            }
            
        }
        
        return answer;
    }
}
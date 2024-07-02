class array_delete {
    public int[] array_delete(int[] arr, int[] delete_list) {
        int count =0;
        boolean exist = false;
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=0;j<delete_list.length;j++){
                if(arr[i]==delete_list[j]){
                    exist = true;
                }
            }
            
            if(!exist){
                count++;
            }
            
            exist = false;
            
        }
        
        int[] answer = new int[count];
        count=0;
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=0;j<delete_list.length;j++){
                if(arr[i]==delete_list[j]){
                    exist = true;
                }
            }
            
            if(!exist){
                answer[count++] = arr[i];
            }
            
            exist = false;
        }
        
        return answer;
    }
}
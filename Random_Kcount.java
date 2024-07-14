class Random_Kcount {
    public int[] Random_Kcount(int[] arr, int k) {
        int[] answer = new int[k];
        boolean event= false;
        int count =0;
        
        for(int i=0;i<answer.length;i++){
            answer[i] = -1;
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<answer.length;j++){
                if(arr[i]==answer[j]){
                    event = true;
                }
            }
            
            if(!event){
                if(count!=k){
                    answer[count++]= arr[i];
                }
            }
            
            event = false;
        }

        
            
        
        return answer;
    }
}
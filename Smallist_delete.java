class Smallist_delete {
    public int[] Smallist_delete(int[] arr) {
        
        if(arr.length==1){
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[arr.length-1];
            int min =100000000;
            int count =0;

            for(int i=0;i<arr.length;i++){
                if(min>arr[i]){
                    min = arr[i];
                    count =i;
                }    
            }
            
            int index=0;

            for(int i=0;i<arr.length;i++){
                if(i!=count){
                    answer[index++] = arr[i];
                }
            }


            return answer;
        }
        
        
    }
}
class Two_Arrea {
    public int[] Two_Arrea(int[] arr) {
        int frontindex=-1;
        int backindex=-1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                frontindex=i;
                break;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==2){
                backindex=i;
                break;
            }
        }
        
        if(frontindex==backindex){
            if(frontindex==-1){
                int[] answer = {-1};
                return answer;
            }
            else{
                int[] answer = {2};
                return answer;
            }
        }
        else{
            int[] answer = new int[backindex-frontindex+1];
            int count=0;
            for(int i=frontindex;i<backindex+1;i++){
                answer[count++] = arr[i];
            }
            return answer;
        }
        
        
    }
}
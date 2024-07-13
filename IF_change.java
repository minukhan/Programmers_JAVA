class IF_change {
    public int IF_change(int[] arr) {
        int answer = 0;
        int count=0;
        
        while(true){
            for(int i=0;i<arr.length;i++){
                if(arr[i]>=50){
                    if(arr[i]%2==0){
                        arr[i] = arr[i]/2;
                        count++;
                    }
                }
                else{
                    if(arr[i]%2==1){
                        arr[i] = arr[i]*2 +1;
                        count++;
                    }
                }
            }
            
            if(count==0){
                break;
            }
            
            answer++;
            count=0;
        }

        
        return answer;
    }
}
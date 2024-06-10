class nearNumber {
    public int nearNumber(int[] array, int n) {
        int answer = 0;
        int index =0;
        int min =Integer.MAX_VALUE;
        
        
        for(int i=0;i<array.length;i++){
            if(array[i]>n){
                if(min > (array[i] - n)){
                    index = i;
                    min = array[i]-n;
                }
                else if(min == (array[i] - n)){
                    if(array[index]>array[i]){
                        index=i;
                        min = array[i]-n;
                    }
                }
            }
            else{
                if(min > (n-array[i])){
                    index = i;
                    min = n-array[i];
                }
                else if(min == (n-array[i])){
                    if(array[index]>array[i]){
                        index=i;
                        min = n-array[i];
                    }
                }
            }
        }
        answer = array[index];
        
        return answer;
    }
}
class array_compare {
    public int array_compare(int[] arr1, int[] arr2) {
        int answer = 0;
        int arr1Size =0;
        int arr2Size =0;
        
        if(arr1.length>arr2.length){
            answer = 1;
        }
        else if(arr1.length<arr2.length){
            answer = -1;
        }
        else{
            for(int i=0;i<arr1.length;i++){
                arr1Size+= arr1[i];
                arr2Size+= arr2[i];
            }
            if(arr1Size>arr2Size){
                answer = 1;
            }
            else if (arr1Size<arr2Size){
                answer = -1;
            }
            else{
                answer = 0;
            }
        }
        
        return answer;
    }
}
class Stringarray3 {
    public int[] Stringarray3(int[] arr, int k) {
        
        if(k%2==0){
            for(int i=0;i<arr.length;i++){
                arr[i] += k;
            }
        }
        else{
            for(int i=0;i<arr.length;i++){
                arr[i] *= k;
            }
        }
        
        return arr;
    }
}
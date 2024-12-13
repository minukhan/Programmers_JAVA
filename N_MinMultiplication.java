class N_MinMultiplication {
    public int N_MinMultiplication(int[] arr) {
        int answer = arr[0];
        
        for(int i=1;i<arr.length;i++){
            answer = minmulti(arr[i], answer);            
        }
        return answer;
    }
    
    //최대 공약수    
    private int maxdivision (int first, int second){
        
        int result=0;
        int max = Math.max(first,second);
        
        for(int i=1;i<max;i++){
            if(first % i ==0 && second % i ==0){
                result = i;
            }
        }
        
        return result;
    }
    
    private int minmulti (int first, int second){
        int result = first * second / maxdivision(first,second);
        return result;
    }
}
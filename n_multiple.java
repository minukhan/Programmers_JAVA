class n_multiple {
    public int[] n_multiple(int n, int[] numlist) {
    
        int count=0;
        
        for(int i=0;i<numlist.length;i++){
            if(numlist[i]%n==0){
               count++;
            }
        }
        
        int []answer = new int[count];
        
        count =0;
        
        for(int i=0;i<numlist.length;i++){
            if(numlist[i]%n==0){
                answer[count++] = numlist[i];
            }
        }
        
        
        return answer;
    }
}

class Make_array {
    public int[] Make_array(int n, int k) {
        int count=0;
        
        for(int i=1;i<=n;i++){
            if(i%k==0){
                count++;                
            }
        }
        int[] answer = new int[count];
        count=0;
        for(int i=1;i<=n;i++){
            if(i%k==0){
                answer[count++] = i;        
            }
        }
        
        return answer;
    }
}
class divison_int {
    public int[] divison_int(int n) {
        String divison = "";
        int count=0;
        int div =0;
        div = n;
        
        for(int i=2;i<=div;i++){
            if(div%i==0){
                count++;
            }
            while(div%i==0){
                div = div/i; 
            }
        }
        
        int[] answer = new int[count];
        int k=0;
        boolean swi = true;
        
        for(int i=2;i<=n;i++){
            while(n%i==0){
                n = n/i;
                if(swi){
                    answer[k] = i;
                    k++;
                }
                swi = false;
            }
            swi = true;
        }
        return answer;
    }
}
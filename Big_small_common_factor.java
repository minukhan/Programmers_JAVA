class Big_small_common_factor {
    public int[] Big_small_common_factor(int n, int m) {
        int[] answer = new int[2];
        int max =0;
        int bigfacter=0;
        
        if(n>m){
            max = n;    
        }
        else{
            max =m;
        }
        
        for(int i=1;i<=max;i++){
            if(n%i==0 && m%i==0){
                bigfacter = i;
            }
        }
        
        int minc = m;
        int ninc = n;
        
        while(true){
            if(n>m){
                m +=minc;
                if(n==m){
                    break;
                }
            }
            else{
                n +=ninc;
                if(n==m){
                    break;
                }
            }
        }
        answer[0] = bigfacter;
        answer[1] = m;
        
        
        return answer;
    }
}
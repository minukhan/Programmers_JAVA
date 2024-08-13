class reapply {
    public int reapply(int n, int m, int[] section) {
        int answer = 0;
        int count =m;
        
        boolean[] unpaint = new boolean[n+1];
        
        for(int j=0;j<section.length;j++){
            unpaint[section[j]] = true;
        }
        
        for(int i=1;i<=n;i++){
            if(unpaint[i]==true){
                answer++;
                while(count>0){
                    unpaint[i] = false;
                    if(count==1 || i==n){
                        break;
                    }
                    count--;
                    i++;
                }   
            }
            count=m;
        }
        
        
        return answer;
    }
}
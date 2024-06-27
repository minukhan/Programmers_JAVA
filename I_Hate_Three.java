class I_Hate_Three {
    public int I_Hate_Three(int n) {
        int answer = 0;
        int threeno =1;
        int count=0;
        
        for(int i=0;i<n;){
            boolean three=true;
            
            count = threeno;
            while(threeno>0){
                if(threeno%10==3){
                    three = false;
                    break;
                }
                threeno= threeno/10;
            }
            if(three && count%3!=0){
                i++;
                answer=count; 
            }
            
            threeno = count+1;
        }
        return answer;
    }
}


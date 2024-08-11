class Prime_number_making {
    public int Prime_number_making(int[] nums) {
        int answer = 0;
        int number = 0;
        int i=0;
        int k=2;
        int j=1;
        boolean finish=true;
        int count=0;
        
        while(finish){
            number = nums[i] + nums[j] + nums[k];
            count=0;
            
            for(int u=1;u*u<=number;u++){
                if(number%u==0){
                    count++;
                    if(u!=number/u){
                        count++;
                    }
                }
            }
            if(count==2){
                answer++;
            }
            
            if(k!=nums.length-1){
                k++;
            }
            else if(j!=nums.length-2){
                j++;
                k=j+1;
            }
            else if(i!=nums.length-3){
                i++;
                k=i+2;
                j=i+1;
            }
            else{
                finish = false;
            }
        }
            
        return answer;
    }
}
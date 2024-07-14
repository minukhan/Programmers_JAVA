class Making_array2 {
    public int[] Making_array2(int l, int r) {
        int count =0;
        boolean five_zero=true;
        
        for(int i=l;i<=r;i++){
            
            String num = String.valueOf(i);
            
            for(int j=0;j<num.length();j++){
                if(num.charAt(j)=='0' || num.charAt(j)=='5'){
                   
                }
                else{
                    five_zero = false;
                    break;
                }
            }
            
            if(five_zero){
                count++;
            }
            five_zero=true;
            
        }
        
        if(count==0){
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[count];
            count=0;

            for(int i=l;i<=r;i++){

                String num = String.valueOf(i);

                for(int j=0;j<num.length();j++){
                    if(num.charAt(j)=='0' || num.charAt(j)=='5'){

                    }
                    else{
                        five_zero = false;
                        break;
                    }
                }

                if(five_zero){
                    answer[count++] = i;
                }
                five_zero=true;

            }
        
        
        
            return answer;
            
        }
        
        
    }
}
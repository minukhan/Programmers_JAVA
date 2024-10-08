class String_seperate {
    public int String_seperate(String s) {
        
        char[] arr = s.toCharArray();
        
        int count=0;
        int xcount =1;
        int answer= 0;
        char x = arr[0];
        
        if(arr.length==1){
            answer++;
        }
        
        for(int i=1;i<arr.length;i++){

            if(x==arr[i]){
                xcount++;
            }
            else{
                count++;
            }
            
            if(i == arr.length-1){
                    answer++;
                    break;
            }
            
            if(xcount==count){
                    x = arr[i+1];
                    answer++;
                    if(i+1==arr.length-1){
                        answer++;
                        break;
                    }
                    i++;
                    xcount=1;
                    count=0;
            }
            
        }
        
        return answer;
    }
}

//log test study main
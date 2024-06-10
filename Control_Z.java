class Control_Z {
    public int Control_Z(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int count=0;
        
        for(int i=0;i<arr.length;i++){ //개수 구하는것
            if(i==arr.length-1){
                count++;
            }
            else if(arr[i]==' '){
                count++;
            }
        }
        
        int[] intarr = new int[count];
        count =0;
        String number = "";
        
        for(int i=0;i<arr.length;i++){
            
            while(arr[i]!=' '){
                number += arr[i];
                i++;
                if(i==arr.length){
                    break;
                }
                
            }
         
            
            if(number.equals("Z")){
                intarr[count] = -intarr[count-1];
                count++;
                number = "";
            }
            else{
                if(!number.equals("")){
                    intarr[count] = Integer.parseInt(number); 
                    number = "";
                    count++;
                }
            }
        }
        for(int k=0;k<count;k++){
                answer += intarr[k];
        }
        
        
        return answer;
    }
}
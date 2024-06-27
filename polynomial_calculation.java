class polynomial_calculation {
    public String polynomial_calculation(String polynomial) {
        String answer = "";
        int x= 0;
        int num=0;
        String[] arr  = polynomial.split(" ");
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].charAt(arr[i].length()-1)=='x'){
                if(arr[i].length()==1){
                    x++;
                }
                else{
                    arr[i] = arr[i].replace("x","");
                    x+= Integer.parseInt(arr[i]);
                    System.out.println(arr[i]);
                    
                }
            }
            else if(arr[i].equals("+")){}
            else{
                num += Integer.parseInt(arr[i]);
            }
        }
        
        if(num==0 && x==0){
            answer="0";
        }
        else if(num==0){
            if(x==1){
                answer = "x";
            }
            else{
                answer = String.valueOf(x) + "x";                
            }
        }
        else if(x==0){
            answer = String.valueOf(num);
        }
        else{
            if(x==1){
                answer = "x + " + String.valueOf(num);
            }
            else{
                answer = String.valueOf(x) + "x + " + String.valueOf(num);
                
            }
        }
        
        
        return answer;
    }
}
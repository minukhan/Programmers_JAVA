class Easy_calculation {
    public int Easy_calculation(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        char symbol = arr[1].charAt(0);
        
        
        if(symbol=='+'){
            answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]); 
            
        }
        else if (symbol=='-'){
            answer = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]); 
            
        }
        else{
            answer = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]); 
        }
        
        return answer;
    }
}
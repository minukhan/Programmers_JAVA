class ShiftString2 {
    public int ShiftString2(String A, String B) {
        int answer = 0;
        char temp;
        
        while(true){
            
            if(A.equals(B)){
                break;
            }
            else if(answer>A.length()){
                answer = -1;
                break;
            }
            else{
                answer++;
            }
            
            char[] arr = A.toCharArray();
            
            temp = arr[A.length()-1];
            
        
            for(int i=A.length()-1;i>0;i--){
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
            
            A="";
            
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
                A+=arr[i];    
            }
            System.out.println(" ");
            
            
        }
        
        
        return answer;
    }
}
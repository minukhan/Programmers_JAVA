class Colatz_sequence {
    public int[] Colatz_sequence(int n) {
        int count=0;
        int number=n;
        
        while(number!=1){
            if(number%2==0){
                number = number/2;
            }
            else{
                number = number*3 + 1;
            }
            
            count++;
        }
        int[] answer = new int[count+1];
        count =1;
        answer[0] = n;
        
         while(n!=1){
            if(n%2==0){
                n = n/2;
            }
            else{
                n = n*3 + 1;
            }
            
            answer[count++] = n;
        }
        
        
        return answer;
    }
}
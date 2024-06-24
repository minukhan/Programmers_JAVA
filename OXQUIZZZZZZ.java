class OXQUIZZZZZZ {
    public String[] OXQUIZZZZZZ(String[] quiz) {
        String[] answer = new String[quiz.length];
        int front=0;
        int back=0;
        int result=0;
        
        for(int i=0;i<quiz.length;i++){
            String[] arr = quiz[i].split(" ");
            
            front = Integer.parseInt(arr[0]);
            back = Integer.parseInt(arr[2]);
            result = Integer.parseInt(arr[4]);
            
            if(arr[1].equals("-")){
                if(result==front-back){
                    
                    answer[i] = "O";
                }
                else{
                    answer[i] = "X";
                }
            }
            else if(arr[1].equals("+")){
                if(result==front+back){
                    answer[i] = "O";
                }
                else{
                    answer[i] = "X";
                }
            }
        }
        
        return answer;
    }
}
class x_space {
    public int[] x_space(String myString) {
        String[] arr = myString.split("x");
        int[] answer;
        
        if(myString.charAt(myString.length()-1)=='x'){
            answer = new int[arr.length+1];
            for(int i=0;i<answer.length-1;i++){
                answer[i] = arr[i].length();
            }
            answer[answer.length-1] = 0;
        }
        else{
            answer = new int[arr.length];
            for(int i=0;i<answer.length;i++){
                answer[i] = arr[i].length();
            }
        }
        
        return answer;
    }
}
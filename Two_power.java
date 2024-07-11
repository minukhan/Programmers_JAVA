class Two_power {
    public int[] Two_power(int[] arr) {
        int count=1;
        for(int i=0;i<11;i++){
            if(arr.length<=Math.pow(2,i)){
                count = (int)Math.pow(2,i);
                break;
            }
        }
        int[] answer = new int[count];
        
        for(int i=0;i<answer.length;i++){
            if(i<arr.length){
                answer[i] = arr[i];
            }
            else{
                answer[i] = 0;
            }
        }
        
        
        return answer;
    }
}
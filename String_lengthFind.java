class String_lengthFind {
    public int String_lengthFind(String[] strArr) {
        int answer = 0;
        int[] arr = new int[31];
        for(int i=0;i<strArr.length;i++){
            arr[strArr[i].length()]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>answer){
                answer = arr[i];
            }            
        }
        
        return answer;
    }
}
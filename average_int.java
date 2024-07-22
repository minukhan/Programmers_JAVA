class average_int {
    public double average_int(int[] arr) {
        double answer = 0;
        double hap = 0;
        
        for(int i=0;i<arr.length;i++){
            hap += arr[i];
        }
        
        answer = hap/arr.length;
        
        return answer;
    }
}
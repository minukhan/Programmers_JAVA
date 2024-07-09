class Front_String {
    public int Front_String(String my_string, String is_prefix) {
        int answer = 0;
        char[] arr = my_string.toCharArray();
        String front="";
        
        for(int i=0;i<arr.length;i++){
            front += arr[i];
            if(front.equals(is_prefix)){
                answer = 1;
            }
        }
        
        return answer;
    }
}
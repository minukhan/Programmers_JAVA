class blank_String2 {
    public String[] blank_String2(String my_string) {
        String[] arr = my_string.split(" ");
        int count =0;
        
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                count++;
            }
        }
        
        String [] answer = new String[count];
        count =0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                answer[count++] = arr[i];
            }
        }
        return answer;
    }
}
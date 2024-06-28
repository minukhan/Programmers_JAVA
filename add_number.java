class add_number {
    public int add_number(int[] num_list) {
        int answer = 0;
        String odd="";
        String even="";
        
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2==0){
                even = even+num_list[i];
            }
            else{
                odd = odd+num_list[i];
            }
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even);
        
        return answer;
    }
}
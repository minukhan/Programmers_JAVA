class Last_element2 {
    public int[] Last_element2(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int add_number = 0;
        
        if(num_list[num_list.length-1]>num_list[num_list.length-2]){
            add_number= num_list[num_list.length-1]-num_list[num_list.length-2];
        }
        else{
            add_number = num_list[num_list.length-1]*2;
        }
        
        for(int i=0;i<num_list.length;i++){
            answer[i] = num_list[i];
        }
        answer[num_list.length] = add_number;
        
        return answer;
    }
}
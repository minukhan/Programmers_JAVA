class Odd_Even_compare {
    public int Odd_Even_compare(int[] num_list) {
        int answer = 0;
        int sumeven =0;
        int sumodd=0;
        
        for(int i=0;i<num_list.length;i=i+2){
            sumodd += num_list[i];    
        }
        for(int i=1;i<num_list.length;i=i+2){
            sumeven += num_list[i];    
        }
        if(sumeven>sumodd){
            answer = sumeven;
        }
        else{
            answer = sumodd;
        }
        return answer;
    }
}
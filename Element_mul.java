class Element_mul {
    public int Element_mul(int[] num_list) {
        int answer = 0;
        int add=0;
        int mul =1;
        
        for(int i=0;i<num_list.length;i++){
            add += num_list[i];
            mul *= num_list[i];
        }
        if(add*add>mul){
            answer=1;
        }
        
        return answer;
    }
}
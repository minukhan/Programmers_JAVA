class String_connect_index {
    public String String_connect_index(String my_string, int[] index_list) {
        String answer = "";
        
        for(int i=0;i<index_list.length;i++){
            answer += my_string.charAt(index_list[i]);
        }
        return answer;
    }
}
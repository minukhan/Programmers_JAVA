class PartString {
    public int PartString(String my_string, String target) {
        int answer = 0;
        
        if(my_string.contains(target)){
            answer = 1;
        }
        return answer;
    }
}
import java.util.Arrays;

class BackString_sort {
    public String[] BackString_sort(String my_string) {
        String[] answer = new String[my_string.length()];
        String backString = "";
        
        for(int i=0;i<my_string.length();i++){
            for(int j=i;j<my_string.length();j++){
                backString += my_string.charAt(j);
            }
            answer[i] = backString;
            backString = "";
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
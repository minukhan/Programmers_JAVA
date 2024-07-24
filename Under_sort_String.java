import java.util.Arrays;

class Under_sort_String {
    public String Under_sort_String(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        
        for(int i=arr.length-1;i>=0;i--){
            answer += arr[i];
        }
        
        
        return answer;
    }
}
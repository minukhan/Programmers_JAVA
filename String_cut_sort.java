import java.util.Arrays;

class String_cut_sort {
    public String[] String_cut_sort(String myString) {
        int count=0;
        String[] arr = myString.split("x");
        
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                count++;
            }
        }
        String[] answer = new String[count];
        count=0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                answer[count++] = arr[i];
            }
        }
        System.out.print(count);
        
        
        Arrays.sort(answer);
        
        return answer;
    }
}
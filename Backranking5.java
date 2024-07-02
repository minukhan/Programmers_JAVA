import java.util.Arrays;

class Backranking5 {
    public int[] Backranking5(int[] num_list) {
        int[] answer = new int[5];
        
        Arrays.sort(num_list);
        
        for(int i=0;i<5;i++){
            answer[i] = num_list[i];
        }
        
        return answer;
    }
}
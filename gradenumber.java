import java.util.Arrays;

class gradenumber {
    public int[] gradenumber(int[][] score) {
        int[] answer = new int[score.length];
        float[] answer2 = new float[score.length];
        float[] arr = new float[score.length];
        
        for(int i=0;i<score.length;i++){
            arr[i] = (score[i][0] + score[i][1])/(float)2;
            answer2[i] = (score[i][0] + score[i][1])/(float)2;
        }
        Arrays.sort(arr);
        
        int count=1;
        
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==answer2[j]){
                    answer[j] = -count;
                    answer2[j] = -count;
                }
            }
            count++;
        }
        
        for(int j=0;j<arr.length;j++){
            answer[j] = Math.abs(answer[j]);
        }
        
        return answer;
    }
}
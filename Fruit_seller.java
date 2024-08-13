import java.util.Arrays;

class Fruit_seller {
    public int Fruit_seller(int k, int m, int[] score) {
        int answer = 0;
        int count=0;
        Arrays.sort(score);
        int[] arr = new int[m];
        
        for(int i=score.length-1;i>=0;i--){
            
            if(count!=m){
                arr[count++] = i;
            }
            if(count==m){
                answer += score[i] * m;
                count=0;
            }
        }
        
        return answer;
    }
}
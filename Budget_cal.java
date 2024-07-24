import java.util.Arrays;

class Budget_cal {
    public int Budget_cal(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        Arrays.sort(d);
        
        for(int i=0;i<d.length;i++){
            sum+=d[i];
            if(sum<=budget){
                answer++;
            }
            else{
                break;
            }
        }
        
        return answer;
    }
}
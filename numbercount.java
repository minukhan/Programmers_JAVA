class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int count=0;
        int co=0;
        int index =0;
        
        for(int i=1;i<7;i++){
            if(num>0){
               answer++;
            }
            else{
                break;
            }
            if(num%10==k){
                count++;
                answer=1;
            }
            num = num/10;
        }
        if(count==0){
            answer=-1;
        }
        
         
        return answer;
    }
}
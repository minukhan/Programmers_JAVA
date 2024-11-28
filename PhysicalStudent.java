import java.util.*;

class PhysicalStudent {
    public int PhysicalStudent(int n, int[] lost, int[] reserve) {
        int answer = 0;
           
        int[] physicalStudent = new int[n];
        Arrays.sort(lost);
        
        for(int i=0;i<physicalStudent.length;i++){
            physicalStudent[i] = 1;
        }
        
        for(int i=0;i<reserve.length;i++){
            physicalStudent[reserve[i]-1]++;
        }
        
        for(int i=0;i<lost.length;i++){
            if(physicalStudent[lost[i]-1]>1){
                physicalStudent[lost[i]-1]--;
                lost[i] = -1;
            }
        }
        for(int k=0;k<n;k++){
                System.out.println( "스튜던트 : "+physicalStudent[k]);
            }
        for(int i=0;i<lost.length;i++){
            if(lost[i]==-1){
                continue;
            }
            else if((lost[i]-2)>=0 && physicalStudent[lost[i]-2]>1){
                physicalStudent[lost[i]-2]--;
            }
            else if((lost[i])< physicalStudent.length && physicalStudent[lost[i]]>1){
                physicalStudent[lost[i]]--;
            }
            else{
                physicalStudent[lost[i]-1]--;
            }
        }
        
        for(int i=0;i<physicalStudent.length;i++){
            if(physicalStudent[i]>=1){
                answer++;
            }
        }
        
        return answer;
    }
}
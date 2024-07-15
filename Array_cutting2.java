import java.util.ArrayList;

class Array_cutting2 {
    public int[] Array_cutting2(int[] arr, int[] query) {
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        
        for(int i=0;i<query.length;i++){
            if(i%2==0){
                int len = list.size()-query[i]-1;
                while(len>0){
                    list.remove(query[i]+1);
                    len--;
                }
            }
            else{
                for(int j=0;j<query[i];j++){
                    list.remove(0);
                }
            }
        }
        
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
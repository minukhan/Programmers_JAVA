import java.util.ArrayList;

class Making_array6 {
    public int[] Making_array6(int[] arr) {
        
        ArrayList<Integer> stk= new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(stk.isEmpty()){
                stk.add(arr[i]);
            }
            else if(stk.get(stk.size()-1)==arr[i]){
                stk.remove(stk.size()-1);
            }
            else{
                stk.add(arr[i]);
            }
        }
        
        if(stk.isEmpty()){
            int[] answer ={-1};
            return answer;
        }
        else{
            int[] answer = new int[stk.size()];
        
            for(int i=0;i<answer.length;i++){
                answer[i] = stk.get(i);
            }
            return answer;
            
        }
        
    }
}
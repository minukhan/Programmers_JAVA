import java.util.ArrayList;

class Making_array4 {
    public int[] Making_array4(int[] arr) {
        
        ArrayList<Integer> stk = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(stk.isEmpty()){
                stk.add(arr[i]);
            }
            else if(stk.get(stk.size()-1)<arr[i]){
                stk.add(arr[i]);
            }
            else{
                stk.remove(stk.size()-1);
                i--;
            }
        }
        
        int[] makeArray = new int[stk.size()];
        
        for(int i=0;i<makeArray.length;i++){
            makeArray[i] = stk.get(i);
        }
        
        
        return makeArray;
    }
}
import java.util.ArrayList;

class ArrayList_add_get_remove {
    public int[] ArrayList_add_get_remove(int[] arr, boolean[] flag) {
        int k=0;
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(flag[i]){
                k =arr[i];
                while(k>0){
                    arrList.add(arr[i]);
                    arrList.add(arr[i]);
                    k--;
                }
            }
            else{
                k =arr[i];
                while(k>0){
                    arrList.remove(arrList.size()-1);
                    k--;
                }
            }
        }
        int[] answer = new int[arrList.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}
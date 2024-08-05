import java.util.ArrayList;

class Poketmon {
    public int Poketmon(int[] nums) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i]) && answer<nums.length/2){
                list.add(nums[i]);
                answer++;
            }
        }
        
        return answer;
    }
}
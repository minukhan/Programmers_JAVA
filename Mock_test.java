import java.util.ArrayList;
import java.util.Collections;

class Mock_test {
    public int[] Mock_test(int[] answers) {
        int[] math_giveup1 = {1, 2, 3, 4, 5};
        int[] math_giveup2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] math_giveup3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1=0;
        int count2=0;
        int count3=0;
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==math_giveup1[i%math_giveup1.length]){
                count1++;
            }
            if(answers[i]==math_giveup2[i%math_giveup2.length]){
                count2++;
            }
            if(answers[i]==math_giveup3[i%math_giveup3.length]){
                count3++;
            }
        }
        int max=count1;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        
        if(count1<count2){
            list.clear();
            list.add(2);
            max = count2;
        }
        else if(count1==count2){
            list.add(2);
        }
        if(max<count3){
            list.clear();
            list.add(3);
        }
        else if(max==count3){
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
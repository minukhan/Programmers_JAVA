import java.util.*;

public class Sum_number {
    public int Sum_number(int n) {
        int answer = 0;
        
        while(n>0){
            answer += n%10;
            n = n/10;
        }
        
        return answer;
    }
}
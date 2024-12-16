import java.util.*;

public class JumpAndTeleport {
    public int JumpAndTeleport(int n) {
        
        int answer =0;
        
        while(n>0){
            if(n%2==0){
                n = n/2;
            }
            else{
                answer++;
                n = n/2;
            }
        }
        
        return answer;
    }
}
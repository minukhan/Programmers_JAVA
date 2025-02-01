import java.util.*;

class ChangeNumberByBFS {
    
    public class State{
        public int number;
        public int count;
        
        public State(int number, int count){
            this.number = number;
            this.count = count;
        }
    }
    
    public int ChangeNumberByBFS(int x, int y, int n) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();        
        Queue<State> queue = new LinkedList<>();
        
        queue.add(new State(x,0));
        set.add(x);
        
        while(!queue.isEmpty()){
            State state = queue.poll();
            
            if(state.number==y){
                return state.count;
            }
            
            int[] Case = {state.number + n, state.number * 2, state.number * 3};
            
            for(int i=0;i<Case.length;i++){
                if(Case[i] <= y && set.add(Case[i])){
                    queue.add(new State(Case[i], state.count+1));
                }
            }
        }
        
        return -1;
    }
}
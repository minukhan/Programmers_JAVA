
import java.util.*;
import java.lang.*;
import java.io.*;


class CardGame {
    static int[] card;
    static int[] next;
    public static int[] member;
    public static int winCount =0;
    public static int defeatCount =0;
    public static int[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int size = 1;
        
        while(T-- > 0){
            
            st  = new StringTokenizer(br.readLine());
    
            member  = new int[9];
            HashSet<Integer> set = new HashSet<>();
            
            for(int i=0;i<9;i++){
                member[i] = Integer.parseInt(st.nextToken());    
                set.add(member[i]);
            }
    
            next = new int[9];
            card = new int[9];
            visited = new int[9];
            defeatCount = 0;
            winCount = 0;
            
            int index =0;
            for(int i=1;i<19;i++){
                if(set.contains(i)) continue;
    
                next[index] = i;
                index++;
            }
    
            dfs(0);
            
            sb.append("#"+ size + " ").append(defeatCount + " " + winCount).append("\n");
            size++;
        }
        
        System.out.println(sb.toString());

        
        
    }

    public static int calculation(){
        int one = 0;
        int two = 0;
        
        for(int i=0;i<9;i++){
            if(member[i] > card[i]){
                one += member[i] + card[i];
            }
            else if(member[i] < card[i]){
                two += member[i] + card[i];
            }
        }

        if(one < two) return 1;
        if(one > two) return 0;

        return -1;
        
    }
    
    public static void dfs(int count){

        if(count == 9){
            int result = calculation();
            switch(result){
                case -1:
                    break;
                case 0:
                    defeatCount++;
                    break;
                case 1:
                    winCount++;
                    break;
            }
            return;
        }

        for(int i=0;i<9;i++){

            int current = next[i];

            if(visited[i] == 1) continue;

            visited[i] = 1;
            card[count] = current;
            dfs(count + 1);
            card[count] = 0;
            visited[i] = 0;
        }
    }
}
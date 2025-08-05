import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1339 {
    public static int N;
    public static HashMap<Character, Integer> map;
    public static HashSet<Character> set;
    public static int[] number;
    public static int max = Integer.MIN_VALUE;
    public static ArrayList<String> list;
    public static int[] visited;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        set = new HashSet<>();
        list = new ArrayList<>();
        
        int index =0;
        for(int i=0;i<M;i++){
            String input = br.readLine();
            list.add(input);
            for(int j=0;j<input.length();j++){
                char current = input.charAt(j);
                if(set.contains(current)) continue;
                map.put(input.charAt(j), index);
                set.add(input.charAt(j));
                index++;
            }
        }

        N = set.size();
        number = new int[N];
        visited = new int[10];

        dfs(0);

        System.out.println(max);
        
    }
    public static int answerCount(){
        int sum =0;

        for(int i=0;i<list.size();i++){
            
            String input = list.get(i);
            int result = 0;
            
            for(int j=0;j<input.length();j++){
                result = result * 10 + number[map.get(input.charAt(j))];
            }

            sum = sum + result;
        }

        return sum;
    }

    
    
    public static void dfs(int count){
        
        if(count == N){
            // 계산함수
            int result = answerCount();
            max = Math.max(max,result);
            return;
        }

        for(int i=0;i<10;i++){
            if(visited[i] == 1) continue;

            visited[i] = 1;
            number[count] = i;
            dfs(count + 1);
            number[count] = 0;
            visited[i] = 0;
            
        }
    }
}
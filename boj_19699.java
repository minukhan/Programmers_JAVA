import java.util.*;
import java.lang.*;
import java.io.*;



class boj_19699 {
    public static int N;
    public static int M;
    public static int[] weight;
    public static int[] choice;
    public static HashSet<Integer> set;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        choice = new int[M+1];
        weight = new int[N];
        set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        ArrayList<Integer> list = new ArrayList<>();
        
        for(int value : set){
            list.add(value);    
        }
        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append(" ");    
        }

        if(sb.length() == 0){
            System.out.println(-1);
            return;
        }
        
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int number){

        if(number == 1) return false;

        if(number == 2) return true;

        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }
        return true;
        
    }

    public static int sum(){
        int sum = 0;
        
        for(int i=0;i<M;i++){
            sum += choice[i]; 
        }
        return sum;
    }

    public static void dfs(int count, int index){
        if(count == M){
            int sum = sum();
            if(isPrime(sum)){
                
                set.add(sum);
            }
            return;
        }

        for(int i=index;i<N;i++){

            // 선택한경우
            choice[count] = weight[i];
            dfs(count + 1, i+1);
            choice[count] = 0;

        }
    }
}
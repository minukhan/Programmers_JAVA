import java.util.*;
import java.lang.*;
import java.io.*;

class boj_15665 {

    //N개의 자연수와 하나의 M 이 주어졌을때 길이가 M 인 수열을 구해라
    // N과 M이 주어진다. 이때 8보다 작거나같음.
    // 중복해서 나오면 안됨. 중복처리를 어떻게 할까 하는데 set을 이용하면 되지 않을까 싶네
    // set에 String 형식으로 넣어놓고 contains 를 이용해서 판별

    public static int N;
    public static int M;
    public static int[] num;
    public static int[] record;
    public static StringBuilder sb;
    public static HashSet<String> set;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N]; 
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        set = new HashSet<>();
        record = new int[N];

        Arrays.sort(num);
        
        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int count){
        if(count == M){
            String number = "";
            for(int i=0;i<M;i++){
                number = number + record[i] + " ";
            }
            if(!set.contains(number)){
                set.add(number);
                sb.append(number);
                sb.append("\n");
            }
            return;
        }

        for(int i=0;i<N;i++){

            record[count] = num[i]; 
            dfs(count + 1);
        }
    }
}
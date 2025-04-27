import java.util.*;
import java.lang.*;
import java.io.*;

// 5:32
// I,V X L 을 사용한다 수를 나타내기 위해 1,5,10,50 을 의미한다.
// 문자열이 나타내는 값은 각 문자가 의미하는 수를 모두 합한값
// 문제에서 자릿수를 줬네. 거기에서 그럼 들어갈 문자는 4종류 이떄 중복은 허용하지않음.

class boj_16922 {
    public static int N;
    public static StringBuilder sb;
    public static int answer;
    public static HashSet<Integer> set;
    public static int[] roma = {1,5,10,50};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        set = new HashSet<>();
        
        dfs(0,0,N);
        
        System.out.println(set.size());
    }

    public static void dfs(int count, int sum, int remain){

        if(count ==4){
            if(remain == 0) set.add(sum);
            return;
        }

        for(int i=0;i<=remain;i++){
            dfs(count +1, sum + roma[count] * i, remain -i);
        }
    }

}

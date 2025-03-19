import java.util.*;
import java.lang.*;
import java.io.*;

class MakingCode {
    public static StringBuilder sb;
    public static char[] code;
    public static boolean[] visited;
    public static int C;
    public static int N;
    public static HashSet<String> set;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        code = new char[C];
        sb = new StringBuilder();
        visited = new boolean[C];
        set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            code[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(code);

        dfs(0,"");

        System.out.println(sb.toString());
        
    }
    
    public static void dfs(int index ,String currnetCode){

        if(currnetCode.length()==N){
            if(check(currnetCode)){

                sb.append(currnetCode).append("\n");
            }
            return;
        }

        for(int i=index;i<C;i++){
            dfs(i + 1,currnetCode + code[i]);
        }
        
    }

    public static boolean check( String code){

        int moCount=0;
        int jaCount=0;

        boolean result = false;
        
        for(int i=0;i<code.length();i++){
            char current = code.charAt(i);
            if(current == 'a' || current == 'e' || current == 'i' || current == 'o'|| current == 'u'){
                moCount++;
                continue;
            }
            jaCount++;
        }
        
        if(moCount >=1 && jaCount >=2){
            result = true;
        }
        
        return result;
    }

    
}
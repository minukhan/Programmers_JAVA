import java.util.*;
import java.lang.*;
import java.io.*;


class boj_12101 {
    public static int n;
    public static int k;
    public static ArrayList<String> list;
    public static boolean check = true;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        dfs(0,"");

        // System.out.println(list.size());

        if(list.size() < k){
            System.out.println(-1);
        }
        else{
            System.out.println(list.get(k-1));
        }
        
    }

    // 중복을 어떻게 처리할것인가? 
    // 조합? 
    public static void dfs(int sum, String record){

        if(sum > n){
            return;
        }

        if(sum == n){
            list.add(record);
        }

        for(int i=1;i<4;i++){
            if(record.isEmpty()){
                dfs(sum+i , record + i);
            }
            else{
                dfs(sum + i, record + '+' + i);
                
            }
        }
    }
}
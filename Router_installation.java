import java.util.*;
import java.lang.*;
import java.io.*;

class Router_installation {

    // 최대, 최소? 혹시 파라미터서치? DFS,BFS?

    public static int[] wifi ;
    public static int m;
    
    public static void Router_installation(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wifi = new int[n];

        for(int i=0;i<n;i++){
            wifi[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wifi);
        
        int L = 0;
        int R = 1000000000;
        
        while(L<=R){
            int mid = L + (R-L)/2;

            if(check(mid)){
                L = mid +1;
            }
            else{
                R = mid -1;
            }
        }
        
        System.out.println(L);
    }

    public static boolean check(int distance){
        int last = wifi[0];
        int count=1;

        for(int i=1;i<wifi.length;i++){
            if((last + distance) < wifi[i]){
                last = wifi[i];
                count++;
            }
        }
        return count >=m;
    }
}
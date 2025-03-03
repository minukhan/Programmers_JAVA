import java.util.*;
import java.lang.*;
import java.io.*;

class TreeCut {
    public static int M;
    public static int[] tree;
    
    public static void TreeCut(String[] args) throws IOException {


        // 높이가 h 일때 M개를 구할 수 있는가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[n];
        for(int i=0;i<n;i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }


        int L = 0;
        int R = 2000000000;
        
        while(L<=R){
            int mid = L + (R-L) / 2;

            if(findH(mid)){
               L = mid + 1; 
            }
            else{
                R = mid -1;
            }
        }

        System.out.println(L-1);
    }

    public static boolean findH(int h){

        long sum =0L;
        
        for(int i=0;i<tree.length;i++){
            if(h < tree[i]){
                sum = sum + tree[i] - h;
            }
        }

        return sum >= M;
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class LANLineCut {
    public static int N;
    public static int K;
    public static int[] length;
    
    public static void LANLineCut(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        length = new int[K+1];
        
        for(int i=1;i<K+1;i++){
            length[i] = Integer.parseInt(br.readLine());
        }
        
        long L = 1;
        long R = 1;
        for (int i = 1; i <=K; i++) {
            R = Math.max(R, length[i]);
        }

        while(L <= R){
            long mid = L + (R-L) / 2;

            long count = check(mid);
            
            if(count >= N){
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }

        System.out.println(L-1);
    }

    public static long check(long size){
        long count=0;
        
        for(int i=1;i<length.length;i++){
            count += length[i] / size;
        }

        return count;
    } 
}


// 랜선의 최대 길이를 구해라!

// 랜선의 길이를 설정했을때 최대 몇개까지 가능한가?
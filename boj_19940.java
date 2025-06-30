import java.util.*;
import java.lang.*;
import java.io.*;



class boj_19940 {

    public static int[] arr;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        arr = new int[60];
        
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int zero = N/60;
            int find = N%60;

            init(zero, find);
        }

    }

    public static void init(int zero, int find){
        int N = zero * 60 + find;         
        int answer = Integer.MAX_VALUE;
        sb = new StringBuilder();
        
        // addh 를 zero, zero+1 두 경우 모두 시도
        for(int h = zero; h <= zero + 1; h++){
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 6; j++){
                    for(int k = 0; k < 10; k++){
                        for(int o = 0; o < 10; o++){
                            
                            int result = h * 60
                                       + i * 10
                                       - j * 10
                                       + k
                                       - o;
                            if (result != N) continue;
    
                            int cnt = h + i + j + k + o;
                            if (cnt < answer) {
                                answer = cnt;
                                sb = new StringBuilder();
                                sb.append(h).append(" ")
                                  .append(i).append(" ")
                                  .append(j).append(" ")
                                  .append(k).append(" ")
                                  .append(o);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
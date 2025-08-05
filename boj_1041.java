
import java.util.*;
import java.lang.*;
import java.io.*;



class boj_1041 {

    public static int oneCount;
    public static int twoCount;
    public static int threeCount;
    public static long N;
    public static int[] dice;
    public static int[][] two = {{0,1}, {0,2}, {0,3}, {0,4}, {1,2}, {1,3}, {1,5}, {2,4}, {2,5}, {3,4}, {3,5}, {4,5}};
    public static int[][] three = {{0,1,2}, {0,2,4}, {0,3,4}, {0,1,3}, {5,1,2}, {5,2,4}, {5,3,4}, {5,1,3}};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dice = new int[6];
        
        for(int i=0;i<6;i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        oneCount = Integer.MAX_VALUE;
        twoCount = Integer.MAX_VALUE;
        threeCount = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0;i<6;i++){
            oneCount = Math.min(oneCount, dice[i]);
            max = Math.max(max, dice[i]);
            sum += dice[i];
        }

        if(N==1){
            System.out.println(sum - max);
            return;
        }
    
        two();
        three();
        long answer = ((N-2) * (N-2) * 5 + 4*(N-2)) * oneCount + ((N - 2) * 12 + 4 - 4*(N-2)) * twoCount +  (threeCount * 4);
    
        System.out.println(answer);
    }

    public static void two(){
        for(int i=0;i<12;i++){
            int first = two[i][0];
            int second = two[i][1];

            int result = dice[first] + dice[second];
            twoCount = Math.min(twoCount , result);
        }
    }
    
    public static void three(){
        for(int i=0;i<8;i++){
            int first = three[i][0];
            int second = three[i][1];
            int last = three[i][2];

            int result = dice[first] + dice[second] + dice[last];
            threeCount = Math.min(threeCount , result);
        }
    }
    
}

























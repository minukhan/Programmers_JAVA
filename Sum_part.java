import java.util.*;

import java.lang.*;

import java.io.*;

// The main method must be in a class named "Main".

class Sum_part {

    private static int N;

    private static int answer=0;

    private static int score;

    private static  int[] num;

    

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());

        score = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        

       num = new int[N+1];

        

        for(int i=1;i<N+1;i++){

            num[i] = Integer.parseInt(st.nextToken());

        }

        dfs(1,0,false);

        

        System.out.println(answer);

        

    }

    private static void dfs(int count, int sum, boolean first){

        if(count == N+1 ){

            if(sum == score && first){

                answer++;

            }

            return;

        }

        else{

            dfs(count +1 , sum + num[count], true);

            dfs(count+1, sum,first);

            

        }

    }

}
import java.util.*;
import java.lang.*;
import java.io.*;

class One_Two_Three_Sum {
    public static void One_Two_Three_Sum(String[] args) throws IOException {
        
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<11;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i=0;i<N;i++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class Main {

//     public static int answer=0;
    
//     public static void main(String[] args) throws IOException {

//         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

//         int N = Integer.parseInt(br.readLine());

//         for(int i=0;i<N;i++){
//             dfs(Integer.parseInt(br.readLine()),0);
//             System.out.println(answer);
//             answer =0;
//         }
        
        
//     }

//     public static void dfs(int number, int count){

//         if(count>number) return ;

//         if(count==number){
//             answer++;
//             return;
//         }

//         dfs(number,count+1);
//         dfs(number,count+3);
//         dfs(number,count+2);
        
//     }
// }
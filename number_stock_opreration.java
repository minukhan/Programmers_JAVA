import java.util.*;

import java.lang.*;

import java.io.*;


// The main method must be in a class named "Main".

class number_stock_opreration {

    private static int M;

    private static int N;

    private static int[] select;

    private static boolean[] visited;

    

    private static StringBuilder sb = new StringBuilder();

    

    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            String input1 = br.readLine();

            String[] size = input1.split(" ");

             N = Integer.parseInt(size[0]);

             M = Integer.parseInt(size[1]);

            select = new int[M+1];

            visited = new boolean[N+1];

        

            dfs(1);

            

            System.out.println(sb.toString());

    }

    private static void dfs(int count){

        if(count == M+1){

            

            for(int i=1;i<M+1;i++){

                sb.append(select[i]).append(" ");

            }

            sb.append("\n");

        }

        else{

            for(int i=1;i<=N;i++){

                

                if(visited[i]){

                    continue;

                }

                

                visited[i] = true;

                select[count] = i; 

                dfs(count+1);

                select[count] = 0; 

                visited[i] = false;

            }

        }

            

            

    }

}
import java.util.*;

import java.lang.*;

import java.io.*;

// The main method must be in a class named "Main".

class N_Queen {

    private static int N;

    private static int[] number;

    private static int answer=0;

    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String input1 = br.readLine();
        N = Integer.parseInt(input1);

        number = new int[N+1];
        dfs(1);

        

        System.out.println(answer);

        

    }

    private static boolean attack(int i, int inum, int j, int jnum){

        if(i==j) return true; // 행이 같을때

        if(inum==jnum) return true; // 열이 같을때

        if(i-inum == j-jnum) return true; // 왼쪽 대각선

        if(i+inum == j+jnum) return true; // 오른쪽 대각선

        return false;

    }

    private static boolean check(){

        for(int i=1;i<N+1;i++){

            for(int j=1;j<i;j++){

                if(attack(i,number[i],j,number[j])){

                    return false;

                }

            }

        }

        return true;

    }

    

    private static void dfs(int count){

       if(count == N+1){

           // 확인 서로 공격할 수 있는 위치인지 확인 코드

            if(check()){

                answer++;

            }

       }

        else{

            for(int i=1;i<N+1;i++){

                boolean put = true;

                

                for(int j=1;j<count;j++){

                    if(attack(count,i,j,number[j])){

                        put = false;

                        break;

                    }

                }
                if(put){

                    number[count] = i;

                    dfs(count + 1);

                    number[count] = 0;

                }

                

            }

        }

    }

}
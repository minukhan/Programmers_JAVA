import java.util.*;
import java.lang.*;
import java.io.*;



// 알고리즘
// 시험 전날까지 공부를 하지 않음.
// 문제를 하나도 풀지못했지만 5지선타 객관식 10문제
// 3개의 연속된 문제의 답은 같게 하지 않는다.
// 10이니까 5의 10제곱 하고 조건이 있으니까 시간초과는 안날듯.
// 뺵트래킹으로 해결.

class boj_19949 {
    public static int[] quiz;
    public static int[] answer;
    public static int result=0;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        quiz = new int[10];
        answer = new int[10];
        for(int i=0;i<10;i++){
            quiz[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        
        System.out.println(result);
    }

    public static void dfs(int count){

        if(count ==10){
            if(score()) result++;
            return;
        }


        for(int i=1;i<=5;i++){

            answer[count] = i;
            if(!check(count)) continue;
            
            dfs(count +1);
            answer[count] = 0;
        }
    }

    public static boolean check(int len){

        for(int i=0;i<=len;i++){
            int check = answer[i];

            if(i-1 >= 0 && answer[i-1] == check){
                if(i-2 >= 0 && answer[i-2] == check){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean score(){
        int sum =0;
        for(int i=0;i<10;i++){
            if(quiz[i] == answer[i]) sum++;

            if(sum >= 5){
                return true; 
            }
        }
        return false;
    }
}
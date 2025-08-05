
import java.util.*;
import java.lang.*;
import java.io.*;

// 9: 01

// 백준이는 문제를 N개 가지고있고 모든 문제의 난이도를 정수로 수치화했다. 
// 난이도가 있네.
// 사용할 문제는 2묹 이상이어야 한다.
// L보다 크거나 같고, R 보다 작거나 같아야한다. 
// 어려운 문제와 쉬운 난이도 차이는 X보다 크거나 같아야한다. 
// 캠프에 사용할 문제를 골라라.
// 지금 떠오르는건 투포인터
// 방법의 수를 출력해라.
// 두 문제의 차이는 X보다 크거나 같아야하고, 또 차이의 합은 L 보다 크고 R보다 작아야함. 
// 합은 이분탐색? 투포인터.
// N 은 15개가 있고 1억, X는 10만.난이도는 10만
// 투포인터로 충분히 가능할듯. 

class boj_16938 {

    public static int N;
    public static int inputL;
    public static int inputR;
    public static int X;
    public static int[] quiz;
    public static int answer=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         inputL = Integer.parseInt(st.nextToken());
         inputR = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());

        quiz = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            quiz[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,0);

        System.out.println(answer);
    }
    
    public static void dfs(int count, int index, int max, int min, int sum){

        // 여기에 판단하는 로직
        if(count >= 2){
            int diff = max - min;
            if(sumCheck(sum) && subCheck(diff)){
                answer++;
            }
        }
        
        if(count == N) return;

        for(int i=index;i<N;i++){
            
            int current = quiz[i];
            int nextMax = Math.max(max, current);
            int nextMin = Math.min(min, current);
            
            dfs(count + 1, i+1, nextMax, nextMin, sum + current);
        }
    }

    public static boolean sumCheck(int number){ // 2가지 경우가있음 작을경우, 클경우, 
        if(number >= inputL && number <= inputR) return true;
        return false;
    }

    public static boolean subCheck(int number){
        if(number >= X) return true;
        return false;
    }

}
















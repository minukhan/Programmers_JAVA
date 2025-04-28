import java.util.*;
import java.lang.*;
import java.io.*;


// 5:16
// N개의 수로 이루저니 수열이 있다. 
// 수와 수 사이에 끼워넣을 수 있는 연산자가 있음. +, - * % 다 가능.
// 연산자의 갯수는 N보다 많을 수 있다. 모든 수 사이에는 연산자를 넣어야함.
// 주어진 수의 순서는 바꾸면 안되고 int 범위사용해도 된다고 하고 
// 계산을 다 떄려야함. 그러면 다 탐색하는 방법밖에 없을듯. 조합으로?
// N은 11보다 작고 연산자는 최대 4N개.
// _ _ _ _ _ _  총 N-1개의 연산자가 필요하고 갯수가 정해져있으니까 빽트래킹으로 하면
//될듯..?

class boj_15658 {

    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int[] num;
    public static int[] oper;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        oper = new int[4];

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, num[0]);
        
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int count, int result){
        if(count==N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                int newResult = calculate(result, num[count + 1], i);
                dfs(count + 1, newResult);
                oper[i]++;
            }
        }
        
    }

    public static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0: return a + b; // +
            case 1: return a - b; // -
            case 2: return a * b; // *
            case 3: return a / b; // /
            default: return 0;
        }
    }
}
// 기억해두자 갯수가 여러개로 한정되어있을때 중복은 가능한데
// for문 안에서 if(갯수 > 0 ) 이거 조건으로 탐색하면 조합탐색이 됨.
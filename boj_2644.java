import java.util.*;
import java.lang.*;
import java.io.*;


// 6:52

// 가족 혹은 친적들 사이의 관계를 촌수라는 단위로 표현한다.
// 부모와 자식 사이를 1촌
// 나와 할아버지는 2촌 이런식으로 계산이 되는거임.
// 1~100 까지 연속된 번호로 표시된다.
// 전체 사람의 수는 n 이 주어지고, 둘째줄에는 촌수를 계산해야하는 서로다른 두사람의 번호
// 부모 자식들 간의 관계의 갯수 m 
// 리스트로 만들어서 찾으면 될듯?

class boj_2644 {

    public static ArrayList<Integer>[] list;
    public static int N;
    public static int M;
    public static int first;
    public static int second;
    public static boolean answer;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            list[prev].add(after); 
            list[after].add(prev);
        }

        int[] check = new int[N+1];
        check[first] = 1;
        dfs(first,0, check);

        if(!answer){
            System.out.println(-1);
        }
    }

    public static void dfs(int current, int count, int[] check){

        if(current == second){
            System.out.println(count);
            answer = true;
            return;
        }

        if(count > N) return;

        for(int value : list[current]){
            if(check[value] == 1) continue;
            
            check[value] = 1;
            dfs(value, count +1, check);
        }
        
    }
}


import java.util.*;
import java.lang.*;
import java.io.*;


// 8:21

// 음이 아닌 정수를 0~max 십진법으로 표기했을때, 왼쪽부터 자리수가 감소할때 그 수를 
// 줄어드는 수라고 한다. 같아도 안됨. N번째로 작은 1 : 0 2 : 10 20 21
// 0,1,2,3,4,5,6,7,8,9,10, 20, 21, 30, 31, 32, 40, 41, 42

class boj_1174 {

    public static ArrayList<Long> list;
    public static int N;
    
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        int i=1;
        while(list.size() < N && i<10){
            dfs(0,9,i,0L);
            i++;
        }

            
        if(i>9 && N-1 == list.size()){
            System.out.println("9876543210");
            return;
        }


        list.sort(Comparator.naturalOrder());

        if(list.size() < N){
            System.out.println(-1);
        }
        else{
            System.out.println(list.get(N-1));
        }
    }


    public static void dfs(int count , int index, int end, Long sum){

        if(count == end){
            list.add(sum);
            return;
        }

        //1번째 자릿수
        //2번째 자릿수
        //3번째 자릿수 ~ 이렇게 쭉 간다. break 포인트는 N을 넘어갔을때? for문을 
        // 9부터 돌리면 되려나?
        // 줄어드는 수는 조합 중복 허용하지 않도록.

        for(int i=index;i>=0;i--){
            dfs(count +1, i - 1, end, sum*10 + i);
        }
    }
}
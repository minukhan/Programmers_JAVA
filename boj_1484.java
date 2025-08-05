import java.util.*;
import java.lang.*;
import java.io.*;

//10 : 57

// 다이어트. 
// 새로운 저울을 선물.
// G 킬로를 더 쪘다고 한다. 
// 여기서 말하는 G 킬로그램은 현재 몸무게의 제곱에서 기억하고 있던 몸무게의 제곱을 뺀 것. 
// 현재 몸무게로 가능한것을 모두 출력?
// G가 주어진다. G 는 10만보다 작거나 같은 자연수이다. 
// 현재 몸무게의 제곱에서 기억하고 있던 몸무게의 제곱을 뺀것. 
// x 제곱 - y 제곱 = G
// 여기서 G가 주어지네? 
// 이런 쌍을 찾아라 이건가? 이떄 X 를 출력해라?
// 총 10만까지 가능. 그러면 0부터 10만까지 한번씩 쭉 둘러보면 되나? 
// 이건 차이긴한데 그러면 앞부터? 
// long 으로 처리해야할듯. 

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long L = 1;
        long R = 2;
        ArrayList<Long> list = new ArrayList<>();
        // 현재 몸무게로 가능한 것을 모두 출력?
        while(R <= 100000){
            long current = R * R; 
            long past = L * L; 

            if(N == current - past){
                list.add(R);
                R++;
            }
            else if(N > current - past){
                R++;
            }
            else{
                L++;
            }
        }

        if(list.isEmpty()){
            System.out.println(-1);
        }
        else{
            list.sort(Comparator.naturalOrder());
            for(long value : list){
                System.out.println(value);
            }
        }
        
        
    }
}


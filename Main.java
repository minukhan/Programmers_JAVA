
import java.io.*;
import java.util.*;

public class Main {
    static final int BASE = 31;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // 열마다 하나의 해시를 관리
        long[] colHash = new long[C];
        long[] pow = new long[R];
        pow[0] = 1;
        for (int i = 1; i < R; i++) {
            pow[i] = (pow[i - 1] * BASE) % MOD;
        }

        // 초기 해시 계산 (전체 행 기준)
        for (int j = 0; j < C; j++) {
            long hash = 0;
            for (int i = 0; i < R; i++) {
                hash = (hash * BASE + grid[i][j]) % MOD;
            }
            colHash[j] = hash;
        }

        int count = 0;
        for (int remove = 1; remove < R; remove++) {
            Set<Long> set = new HashSet<>();

            for (int j = 0; j < C; j++) {
                // 윗줄 문자 제거 (앞글자 제거)
                colHash[j] = (colHash[j] - (grid[remove - 1][j] * pow[R - remove] % MOD) + MOD) % MOD;
                
                if (!set.add(colHash[j])) {
                    System.out.println(count);
                    return;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;


// 8:45 
// R개의 행과 C개의 열로 이루어진 테이블이 있다. 
// 열을 위에서 아래로 읽어서 하나의 문자열을 만들 수 있다. 
// 가장 위의 행을 지워도 테이블의 열을 읽어서 문자열이 중복되지 않으면 동일한 문자열이 반견!
// 반복을 멈추고 count 의 갯수를 출력. 
// 행과 열의 갯수가 1000개.

// 다돈다?
// 불가능하긴 하네. 1,000,000 번 연산할 수 있다. 가능한데? 아닌데
// 1000개를 보고, 열을 끝까지 가야하니까, 1000번.
// 한줄 하는데 1000 * 1000 번 드는데? 
// 그걸 1000 번 하면 시간초과임.
// 그래서 그러면 미리 만들어놓는것도 괜찮을듯?
// subString?
// 
// Hash 는 계속 초기화해주면 될듯?
// 시간초과는 이분탐색을 떠올려보기.
// DP 도 나쁘지 않았는데 String 을 배열에 저장할때는 OOM 주의하기.
// String 을 Hash값으로 바꿔서 저장하는 방법도 있음. 나중에 쓰일듯.
// 알아두면 좋을듯. 근데 구현은 빡세니까 담에 배우는걸로. 

class boj_2866 {
    public static int N;
    public static int M;
    public static char[][] road;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        road = new char[N][M];

        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            for(int j=0;j<M;j++){
                road[i][j] = input.charAt(j);
            }   
        }

        int L = 0;
        int R = N-1;
        int answer = 0;

        while(L <= R){
            int mid = R - (R - L) / 2;

            // 만약 중복이 아니라면 
            if(check(mid)){
                answer = mid;
                L = mid + 1;
            }
            else{ // 중복이라면 
                R = mid - 1;
            }
        }

        System.out.println(answer);
        

        
    }
    public static boolean check(int index){

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<M;i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j=index;j<N;j++){
                sb.append(road[j][i]);
            }
            String next =sb.toString();
            if(set.contains(next)) return false;
            set.add(next);
        }

        return true;
        
    }
}







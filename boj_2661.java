import java.util.*;
import java.lang.*;
import java.io.*;

// 1:14
// 좋은 수열 1,2,3 으로만 이루어지는 수열이 있다 
// 임의ㅢ 길이의 인접한 두개의 부분수열이 동일한게 있으면 그 수열을 나쁜수열이라함.
// 연속되는부분이 있으면 안된다는말. 이거를 판단하는걸 생각해보니까 아무리생각해도 안나옴
// 그냥 N을 줬을때 검사를 다 한다고하면 시간초과가 나고 
// 빽트래킹 방법중에 N일떄 검사하는 방법, 그리고 dfs 들어가기전에 검사하는 방법
// 당연히 들어가기전에 검사하는 방법이 효율적임. 
// 음 그리고 검사하는 아이디어는 for문을 0~N 부터 시작해서 끝까지 돌리는데 여기서
// 2로 나누어서 분리해놓고 찾는아이디어가 있었음.

class boj_2661 {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dfs(0);
    }

    static void dfs(int count) {
        if (count == N) {
            // 숫자 하나씩 바로 출력
            for (int i = 0; i < N; i++) {
                System.out.print(num[i]);
            }
            System.out.println();
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            num[count] = i;
            if (check(count + 1)) {
                dfs(count + 1);
            }
            // 백트래킹
            num[count] = 0;
        }
    }

    // length까지 좋은 수열인지 검사
    static boolean check(int len) {
        for (int i = 1; i <= len / 2; i++) {
            boolean same = true;
            for (int j = 0; j < i; j++) {
                if (num[len - 1 - j] != num[len - 1 - i - j]) {
                    same = false;
                    break;
                }
            }
            if (same) return false;
        }
        return true;
    }
}


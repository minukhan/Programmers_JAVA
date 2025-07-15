import java.io.*;
import java.util.*;

public class boj_1477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 기존 휴게소 수
        int M = Integer.parseInt(st.nextToken()); // 추가로 지을 휴게소 수
        int L = Integer.parseInt(st.nextToken()); // 고속도로 길이

        List<Integer> rest = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rest.add(Integer.parseInt(st.nextToken()));
            }
        }

        rest.add(0);
        rest.add(L);
        Collections.sort(rest);

        int left = 1;     
        int right = L;   
        int answer = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int needed = 0;            

            for (int i = 1; i < rest.size(); i++) {
                int dist = rest.get(i) - rest.get(i - 1);
                needed += (dist - 1) / mid;
            }

            if (needed > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

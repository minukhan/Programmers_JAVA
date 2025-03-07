import java.util.*;
import java.io.*;

class VIdioLesson {
    public static int[] vidio;

    public static void VIdioLesson(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vidio = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxVidio = 0, sumVidio = 0;
        for (int i = 0; i < N; i++) {
            vidio[i] = Integer.parseInt(st.nextToken());
            maxVidio = Math.max(maxVidio, vidio[i]);
            sumVidio += vidio[i];
        }

        int L = maxVidio, R = sumVidio;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            int count = check(mid);

            if (count > M) { // 블루레이 개수가 너무 많으면 크기를 키운다.
                L = mid + 1;
            } else { // 블루레이 개수가 M 이하라면 크기를 줄일 수 있음.
                R = mid - 1;
            }
        }

        System.out.println(L);
    }

    public static int check(int size) {
        int count = 1, sum = 0; // 최소 한 개의 블루레이는 필요하다.

        for (int i = 0; i < vidio.length; i++) {
            if (sum + vidio[i] > size) { // 현재 블루레이 크기를 초과하면 새로운 블루레이 사용
                count++;
                sum = vidio[i];
            } else {
                sum += vidio[i];
            }
        }

        return count;
    }
}

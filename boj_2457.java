import java.util.*;
import java.io.*;

class boj_2457 {

    static class Node {
        int month;
        int day;
        int afterMonth;
        int afterDay;
        
        public Node(int month, int day, int afterMonth, int afterDay) {
            this.month = month;
            this.day = day;
            this.afterMonth = afterMonth;
            this.afterDay = afterDay;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int afterMonth = Integer.parseInt(st.nextToken());
            int afterDay = Integer.parseInt(st.nextToken());
            list.add(new Node(month, day, afterMonth, afterDay));
        }

        list.sort((o1, o2) -> {
            if (o1.month != o2.month) return o1.month - o2.month;
            if (o1.day != o2.day) return o1.day - o2.day;
            if (o1.afterMonth != o2.afterMonth) return o2.afterMonth - o1.afterMonth;
            return o2.afterDay - o1.afterDay;
        });

        int count = 0;
        int i = 0;
        int startMonth = 3, startDay = 1;
        int targetMonth = 12, targetDay = 1; 

        while (startMonth < targetMonth || (startMonth == targetMonth && startDay < targetDay)) {
            boolean found = false;
            int maxEndMonth = startMonth, maxEndDay = startDay;

            while (i < N) {
                Node flower = list.get(i);
                
                if (flower.month > startMonth || (flower.month == startMonth && flower.day > startDay)) {
                    break;
                }
                
                if (flower.afterMonth > maxEndMonth || (flower.afterMonth == maxEndMonth && flower.afterDay > maxEndDay)) {
                    maxEndMonth = flower.afterMonth;
                    maxEndDay = flower.afterDay;
                    found = true;
                }
                i++;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            startMonth = maxEndMonth;
            startDay = maxEndDay;
            count++;
        }

        System.out.println(count);
    }
}

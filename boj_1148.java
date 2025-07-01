import java.util.*;
import java.io.*;

class boj_1148 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String in = br.readLine();
            if (in.equals("-")) break;
            list.add(in);
        }

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;

            int[] map = new int[26];
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                map[c - 'A']++;
            }

            ArrayList<Character> centers = new ArrayList<>();
            boolean[] seen = new boolean[26];
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!seen[c - 'A']) {
                    seen[c - 'A'] = true;
                    centers.add(c);
                }
            }
            Collections.sort(centers);

            int[] libMap = new int[26];
            int[] findlib = new int[26];

            for (char center : centers) {
                int cnt = 0;

                for (String value : list) {
                    if (value.length() < 4) continue;

                    if (value.indexOf(center) < 0) continue;

                    Arrays.fill(findlib, 0);
                    boolean ok = true;

                    for (int j = 0; j < value.length(); j++) {
                        char lib = value.charAt(j);
                        int idx = lib - 'A';
                        findlib[idx]++;
                        if (findlib[idx] > map[idx]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) cnt++;
                }

                libMap[center - 'A'] = cnt;
            }

            int minCount = Integer.MAX_VALUE;
            int maxCount = Integer.MIN_VALUE;

            for (char center : centers) {
                int v = libMap[center - 'A'];
                minCount = Math.min(minCount, v);
                maxCount = Math.max(maxCount, v);
            }

            StringBuilder minAnswer = new StringBuilder();
            StringBuilder maxAnswer = new StringBuilder();
            for (char center : centers) {
                int v = libMap[center - 'A'];
                if (v == minCount) minAnswer.append(center);
                if (v == maxCount) maxAnswer.append(center);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(minAnswer)
              .append(" ")
              .append(minCount)
              .append(" ")
              .append(maxAnswer)
              .append(" ")
              .append(maxCount);

            System.out.println(sb.toString());
        }
    }
}

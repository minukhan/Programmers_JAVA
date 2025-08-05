import java.util.*;
import java.lang.*;
import java.io.*;


public class boj_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] index = new int[6];
        int[] len = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            index[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        int maxWidth = 0, maxHeight = 0;
        int maxWidthIndex = 0, maxHeightIndex = 0;

        for(int i=0;i<6;i++){
            if(index[i] == 1 || index[i] == 2){
                if(len[i] > maxWidth){
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }
            }
            else{
                if(len[i] > maxHeight){
                    maxHeight = len[i];
                    maxHeightIndex = i;
                }
            }
        }

        int findY = Math.min(len[(maxWidthIndex + 1) % 6], len[(maxWidthIndex + 5) % 6]);
        int findX = Math.min(len[(maxHeightIndex + 1) % 6], len[(maxHeightIndex + 5) % 6]);
        
        int result = maxWidth * maxHeight - ((maxHeight - findY) * (maxWidth - findX));

        System.out.println(result * N);
        
    }
}
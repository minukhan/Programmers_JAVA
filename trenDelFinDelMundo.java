import java.io.*;
import java.util.*;

public class trenDelFinDelMundo {

    public static void main(String[] args) throws IOException {

        int min = 1000000000;
        String answer="";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");

            if(min > Integer.parseInt(input[1])){
                min = Integer.parseInt(input[1]);
                answer = Integer.parseInt(input[0]) + " " + Integer.parseInt(input[1]);
            }
        }

        System.out.println(answer);
        
    }
}

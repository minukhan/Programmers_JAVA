import java.io.*;
import java.util.*;

public class InitWorkEndWork {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int answer = 0;
        
        for(int i=0;i<5;i++){
            String[] input = br.readLine().split(" ");

                String[] initWork = input[0].split(":");
                String[] endWork = input[1].split(":");
            answer += (Integer.parseInt(endWork[0]) - Integer.parseInt(initWork[0])) * 60;  
            answer += (Integer.parseInt(endWork[1]) - Integer.parseInt(initWork[1]));  

        }
        System.out.println(answer);
    }
}

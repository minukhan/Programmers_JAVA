import java.io.*;
import java.util.*;

public class Mileage {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        String[] input = br.readLine().split(" ");

        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        String answer;
        
        if(num1>num2){
            answer = "A";
        }
        else if(num1==num2){
             answer = "same";   
        }
        else{
            answer= "B";
        }

        System.out.println(answer);
    }
}

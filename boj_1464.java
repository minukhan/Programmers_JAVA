import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1464 {

    static StringBuilder answer = new StringBuilder();
    static String input;
    static char now = Character.MAX_VALUE;

    static void check(){
        if(now > answer.charAt(answer.length()-1)) answer.insert(0, now);
        else answer.append(now);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();

        answer.append(input.charAt(0));
        for(int i=1; i<input.length(); i++){
            now = input.charAt(i);
            check();
        }

        System.out.println(answer.reverse().toString());
    }
}
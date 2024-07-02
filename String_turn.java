import java.util.Scanner;

public class String_turn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(int i=0;i<a.length();i++){
            System.out.println(a.charAt(i));
        }
    }
}
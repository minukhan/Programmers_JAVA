import java.util.Scanner;

public class print_formula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = a+b;
        
        System.out.println(a +" + "+ b+ " = " + answer);
    }
}
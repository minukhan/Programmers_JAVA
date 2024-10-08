import java.util.Scanner;


public class PCCE3 {

    public static void PCCE3(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int answer = 0;

        

        for(int i=0; i<6; i++){

            answer += number % 100;

            number /= 100;

        }


        System.out.println(answer);

    }

}
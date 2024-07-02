import java.util.Scanner;

public class String_repeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String answer ="";
        
        for(int i=0;i<n;i++){
            answer+=str;
        }
        
        System.out.print(answer);
        
        //str.repeat(n) 이렇게하면 한줄로 끝낼 수 있다. repeat() 메서드도 알아두자!
    }
}
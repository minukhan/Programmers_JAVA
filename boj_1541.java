import java.util.*;
import java.lang.*;
import java.io.*;


class boj_1541 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String num ="";
        Queue<Integer> nQueue = new LinkedList<>();
        Queue<Character> queue = new LinkedList<>();
        
        for(int i=0;i<input.length();i++){

            char current = input.charAt(i);

            if(current == '+'){
                nQueue.add(Integer.parseInt(num));
                queue.add('+');
                num = "";
                continue;
            }

            if(current == '-'){
                nQueue.add(Integer.parseInt(num));
                queue.add('-');
                num = "";
                continue;
            }
            num+= current;
            if(i+1 == input.length()){
                nQueue.add(Integer.parseInt(num));
            }
            
        }
        
        int sum=nQueue.poll();
        
        while(!queue.isEmpty()){
            char oper = queue.poll();
            int nextNum = nQueue.poll();

            if(oper == '+'){
                sum += nextNum;
            } else {
                sum -= nextNum;

                while(!queue.isEmpty() && queue.peek() == '+'){
                    queue.poll(); // '+' 연산자 버리기
                    sum -= nQueue.poll(); // 해당 숫자도 빼기
                }
            }
        }
        System.out.println(sum);
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;


// 4:54
// 손가락을 수십억개 가지고있음
// 기타를 치려함
// 1~6까지의 줄이있고 각 줄은 P개의 프랫으로 나누어져 있음.
// 어떤줄의 프렛을 여러개 누르고있다면 가장 높은 프렛의 음이 발생
// 더 큰 프렛을 출력할때는 그냥 손 하나 추개해서 넣으면 됨.
// 더 작은 프렛을 출력하려면 손을 떼야함.
// 프렛을 누르거나 떼는것을 손가락 한번 움직였다고 함.
// 어떤 멜로디가 주어졌을때 손가락이 가장 적게 움직이게끔 하는 프로그램
// N개의 음의 수가 있고 한 줄에는 P개의 프렛의 수가있다.
// N 은 500,000 프렛은 300,000 -> 상당히 많은데..
// 손가락은 수십억개고. 멜로디를 연주하려면 일단 n log n 안에 해결해야함.
// stack에다 넣고 관리해도 될듯?
// stack 을 N-1 개 만들어놓고 아니면 떼고 없으면 채우고 

class boj_2841 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for(int i=1;i<7;i++){
            stack[i] = new Stack<>();
        }
        int answer =0;
        

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            
            // 내가 원하는 값보다 크면 pop 을 반복
            while(!stack[index].isEmpty() && stack[index].peek() > point){
                stack[index].pop();
                answer++;
            }
            
            if(!stack[index].isEmpty()){ //비어있지 않으면 

                if(stack[index].peek() == point){
                    
                }
                
                // 스택에서 들여다보고 그값이 내가 원하는 값보다 작으면 add
                if(stack[index].peek() < point){
                    stack[index].add(point);
                    answer++;
                    
                }
            }
            else{ // 비어있으면 
                stack[index].add(point);
                answer++;
                
            }
        }
        
        
        
        System.out.println(answer);
    }
}
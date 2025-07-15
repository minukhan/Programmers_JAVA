
import java.util.*;
import java.lang.*;
import java.io.*;

// 두가지함수가 있다.
// R, D 가 있음.
// R은 배열에 있는 수의 순서를 뒤집는 함수.
// D는 첫번째 수를 버리는 함수.
// 배열이 비어있는데 D를 사용하면 에러가 발생한다.
// 함수는 조합해서 한번에 사용가능. 
// reverse 가 있는 StringBuilder 를 사용하는게 좋아보임. 
// 처음에는 함수, 10만까지 있음. 10만번 해야한다는 소리. 
// 배열은 n 개 있다. 10만개
// 첫번째수를 버린다. 근데 뒤집는게. 그냥 덱 쓰면 되는거아닌가.?
// 덱에 다 넣고 뒤집는다면 뒤에서 빼고 그렇게 가면 될듯?

class boj_5430 {
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        
        while(T-- >0){
            Deque<Integer> queue = new LinkedList<>();

            String move = br.readLine();
            int size = Integer.parseInt(br.readLine());

            String input = br.readLine();
            
            String parsing = "";
            int len = 0;

            // 파싱 코드 
            while(len < input.length()){

                if(input.charAt(len) == '['){
                    len++;
                    continue;
                }
                if(input.charAt(len) == ']'){
                    if(!parsing.isEmpty()){
                        queue.add(Integer.parseInt(parsing));
                    }
                    len++; 
                    continue;
                }
                
                if(input.charAt(len) == ','){
                    queue.add(Integer.parseInt(parsing));
                    parsing = "";
                }
                else{
                    parsing += input.charAt(len);
                }
                len++;
            }

            boolean front = true;
            boolean check = true;
            
            for(int i=0;i<move.length();i++){

                
                switch(move.charAt(i)){
                    case 'R':
                        if(front){
                            front = false;  
                        }
                        else{
                            front = true;  
                        } 
                        break;
                    case 'D':
                        if(queue.size() == 0){
                            check = false;
                            break;
                        }
                        
                        if(front){
                            queue.poll();
                        }
                        else{
                            queue.pollLast();
                        }
                        break;  
                }
            }

            StringBuilder sb = new StringBuilder();
            
            if(check){
                // 배열로 변환 로직
                sb.append("[");

                int queueSize = queue.size();

                for(int i=0;i<queueSize;i++){
                    if(front){
                        sb.append(queue.poll());
                        if(i != queueSize - 1){
                            sb.append(",");
                        }
                    }
                    else{
                        sb.append(queue.pollLast());
                        if(i != queueSize - 1){
                            sb.append(",");
                        }
                    }
                }

                sb.append("]");
                
            }
            else{
                sb.append("error");
            }

            System.out.println(sb.toString());
            
        }
        
    }
}
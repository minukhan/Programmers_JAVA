import java.util.*;
import java.lang.*;
import java.io.*;


// 10 :54

// 괄호 4개를 이용해서 만들어지는 괄호열
// 올바른 괄호열이란? 
// 한쌍의 괄호로만 이루어져있으면 올바른 괄호열
// 사이에 껴있어도 올바른 괄호열.
// 만약 올바르다면 두개 붙여도 됨. 
// 아무리봐도 스택인데

// 우리는 올바른 괄호열 x에 대해서 괄호열의 값을 아래에 정의
// () 값은 2이다.
// [] 값은 3
// ( x ) 괄호값은 2 * x값으로 계산된다.
// [x] 괄호값은 3 *x 값으로 계산된다.
// 결합되어있으면 + 
// 길이는 30이하이다. 만약 2 의 15승이면 
// 그래도 int 범위는 안넘어가서 int 사용가능

// #####
// 올바르지 못한 괄효열이면 0을 출력

class boj_2504 {

    static class Node{
        char c;
        int value;
        public Node(char c, int value){
            this.c = c;
            this.value = value;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        Stack<Node> stack = new Stack<>();
        int answer =0;
        boolean check = true;
        
        for(int i=0;i<input.length();i++){
            char current = input.charAt(i);

            if (current == '(' || current == '[') {
                stack.push(new Node(current, 0));
            }
            else{
                // 만약 비어있으면 끝.
                if(stack.isEmpty()){
                    check = false;
                    break;
                }

                Node node = stack.pop();

                if(node.c == '('){
                    if (current != ')') {
                        check = false;
                        break;
                    }
                }
                else{
                    if (current != ']') {
                        check = false;
                        break;
                    }
                }
                int currentValue = (current == ')') ? 2 : 3;
                int nextValue = 0;

                if(node.value == 0){
                    nextValue = currentValue;
                }
                else{
                    nextValue = node.value * currentValue;
                }
                
                if(!stack.isEmpty()){
                    stack.peek().value += nextValue;
                }
                else{
                    answer += nextValue;
                }

                
            }
        }

        if(!check || !stack.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }


    }
}
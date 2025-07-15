import java.util.*;
import java.lang.*;
import java.io.*;


// 수빈이는 A와 B로만 이루어진 영어단어가 존재한다.
// 문자열 S 와 T가 주어졌을때 S 를 T로 바꾸는 게임을 만든다. 
// 문자열을 바꿀때 2가지 연산이 가능.
// 문자열의 뒤에 A를 추가한다.
// 문자열을 뒤집고 뒤에 B를 추가한다. 
// 완탐?
// S의 길이는 999, T의 길이는 1000 까지 가능. 
// 바꿀 수 있으면 1, 없으면 0 을 출력. 
// 완탐은 너무 길고. 그러면 DP, 그리디. 
// 문자열을 뒤집고 뒤에 B를 추가한다는 건. Deque 를 사용하면 쉽게 처리할 수 있음. 
// 순서는 boolean 변수로 하나 만들어서 처리하고. 
// 계속 확인? 
// len 가 같아질때만 확인? 
// 큐에 계속 넣는다? 
// 접두사?
// 너무 많아지는데..
// 뒤집어볼까?
// 다시 돌아가도록?
// 그러면 A, B 로 가는데.
// 어짜피 뒤에다가 추가하는거자나. 그러면 A, B 가 뒤에 있는거면 A, B 를 진행한것.
// 그래서 계속 복원하다가 길이가 같아졌을때, 같다면 바꿀 수 있는것, 없으면 바꿀 수 없는것.

class boj_12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        String start = br.readLine();
        String end = br.readLine();

        StringBuilder sb=  new StringBuilder();
        sb.append(end);
        
        for(int i=end.length()-1;i>=0;i--){
            if(sb.length() == start.length()){
                break;
            }

            switch(sb.charAt(i)){
                case 'A':
                    sb.deleteCharAt(i);
                    break;
                case 'B':
                    sb.deleteCharAt(i);
                    sb.reverse();
                    break;
            }
        }

        if(sb.toString().equals(start)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
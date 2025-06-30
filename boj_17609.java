import java.util.*;
import java.lang.*;
import java.io.*;

// 9:12

// 1. 회문인지 아닌지 판단.
// 2. 만약 회문이 아니라면 그 오른쪽 무시하고 진행
// 3. 그랬을때 아니라면 왼쪽도 진행. 둘다 아니라면 
// 4. 유사회문도 아닌것. 
// 자료구조는 뭘 사용? 
// 배열로 해도 문제없을듯. 

class boj_17609 {

    public static int answer=0;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            String input = br.readLine();

            check(input);
            System.out.println(answer);
            answer =0;

        }

        
    }

    public static void check(String input){

        char[] arr = input.toCharArray();

        int len = input.length();

        int start = 0;
        int end = len-1;
        int count=0;

        while(start <= end){

            if(arr[start] == arr[end]){
                start++;
                end--;
                continue;
            }
            else{
                boolean last = false;
                // 오른쪽을 감소시키고 한번더
                if(lastCheck(arr, start, end-1)){
                    last = true;
                };
                // 왼쪽을 증가시키고 한번 더 .
                if(lastCheck(arr, start + 1, end)){
                    last = true;
                }

                if(!last){
                    answer =2;
                    break;
                }
                else{
                    answer = 1;
                    break;
                }
            }
        }

    }

    public static boolean lastCheck(char[] arr , int start, int end){
        int count=0;
        
        while(start <= end){
            if(arr[start] == arr[end]){
                start++;
                end--;
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
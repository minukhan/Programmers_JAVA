import java.util.*;
import java.lang.*;
import java.io.*;

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
import java.util.*;
import java.lang.*;
import java.io.*;


class boj_9081 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){

            String input = br.readLine();
            System.out.println(nextAnswer(input));
        }
    }

    public static String nextAnswer(String input){

        int[] arr = new int[input.length()];

        for(int i=0;i<arr.length;i++){
            arr[i] = input.charAt(i);
        }

        // 감소하는 구간 index 찾기
        
        int result = -1;
        int i= arr.length -2;
        while(i >= 0){ 

            if(arr[i] < arr[i+1]){
                result = i;
                break;
            }
            i--;
        }

        if(result == -1){
            return input;
        }


        // index 값보다 큰 값 찾기 
        
        int remember = -1;
        i= arr.length -2;
        while(i >= result){ 

            if(arr[result] < arr[i+1]){
                remember = i+1;
                break;
            }
            i--;
        }

        // swap 하기
        int swap =0;
        swap = arr[result];
        arr[result] = arr[remember];
        arr[remember] = swap;

        // copy 배열 만들기
        int[] newArr = new int[arr.length];
        
        for(int j=0;j<arr.length;j++){
            newArr[j] = arr[j];    
        }

        // reverse 된 값 집어넣기
        i= result + 1;
        int len = arr.length-1;
        while(i < arr.length){
            arr[i] = newArr[len];
            len--;
            i++;
        }

        return change(arr);
        
    }
    
    public static String change(int[] arr){

        String answer = "";

        for(int i=0;i<arr.length;i++){
            answer += (char) arr[i];
        }

        return answer;
    }

}
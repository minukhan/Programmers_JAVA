import java.util.*;

class Tiling2 {
    public long solution(int n) {
        int answer = 0;
        
        int first = 1;
        int second = 2;
        int number=0;

        int[] arr = new int[60000];
        arr[0] = first;
        arr[1] = second;
        int i=0;
        while(i<=n-3){
            number = (arr[i] + arr[i+1]) % 1000000007;
            if(i == n-3){
                return number;
            }
            else{
                arr[i+2] = number;
            }
            i++;
        }
        return number;
    }
}
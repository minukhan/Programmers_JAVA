import java.util.*;
import java.lang.*;
import java.io.*;

// 구멍을 막을 두 레고 조각이 필요하다. 
// 너비는 x 센티미터, 두 조각의 길이의 합은 정확하게 일치해야한다.
// 구멍은 항상 2조각으로 막아야한다.
// 구멍의 너비가 X 로 되어있고 레고 조각의 수 N이 주어진다. 
// 레고 조각의 길이 L 이 주어진다. L은 양의 정수이며 
/// n 이 1000000 100만 이므로 nlogn 으로 처리해야함. 

class boj_3649 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));


        String line;
        while((line = br.readLine()) != null){

            int find = Integer.parseInt(line)* 10000000;
            int N = Integer.parseInt(br.readLine());
    
            int[] size = new int[N];
            
            for(int i=0;i<N;i++){
                size[i] =Integer.parseInt(br.readLine());
            }
    
            Arrays.sort(size);
            
            int first = 0;
            int second = 0;
            
            int L = 0;
            int R = N - 1;
            int max = Integer.MIN_VALUE;
            boolean check = false;
            
            while(L < R){
    
                int sum = size[L] + size[R];
    
                // 만약 합이 크다면 뒤를 감소
                if(sum > find){
                    R--;
                }
                else if(sum == find){
                    first =size[L];
                    second =size[R];
                    check = true;
                    break;
                }
                else{
                    L++;
                }
            }
    
    
            StringBuilder sb = new StringBuilder();
            
            if(check){
                sb.append("yes");
            }
            else{
                System.out.println("danger");
                continue;
            }
    
            sb.append(" ").append(first).append(" ").append(second);
            
    
            System.out.println(sb.toString());
        }

        
        
            
        
    }
}
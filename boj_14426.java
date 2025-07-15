
import java.util.*;
import java.lang.*;
import java.io.*;


// 총 M개의 문자열이 주어진다.
// 거기서 적어도 하난의 접두사인 것의 갯수를 구해라.
// N < 10000
// M < 10000

// 집합 S가 주어지거 여기서 접두사인지 판단하는것. 
// 길이는 500이하이다. 
// 같은 무자열은 없고.
// M 개의 문자열 중에서 몇개가 포함되는지? 
// 일단 집합을 넣어놓고 다 돌려보긴해야할듯?
// 만개니까 다 돌리면 1억에 문자열 500이니까 시간초과임

// 그럼 어떻게 찾을까? 
// 사전순 정렬?
// 정렬때리면 A~ Z 까지 정렬될꺼고 앞쪽으로 처리? 
// 

class Main {
    public static String[] arr;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new String[N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        int answer=0;

        for(int i=0;i<M;i++){
            String input = br.readLine();

            int L = 0;
            int R = N-1;
            if(binarySearch(L, R, input)) answer++;
               
        }

        System.out.println(answer);
        
        
    }

    public static boolean binarySearch(int L, int R, String input){

        while(L <= R){
            int mid = R - (R - L)/2;
            String s = arr[mid];

            if(s.startsWith(input)){
                return true;
            }
            // compareTo 메서드 정리 
            if(s.compareTo(input) > 0 ){
                R = mid -1; 
            }
            else{
                L = mid +1; 
            }
        }
        return false;
    }
}
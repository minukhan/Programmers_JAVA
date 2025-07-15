import java.util.*;
import java.lang.*;
import java.io.*;


// 정수 집합 S 가 있고
// 또 다른 K 가 있다. 
// 서로 다른 두개의 정수의 합이 K 에 가장 가까운 두 정수를 구해라. 
// 여러개의 서로다른 정수가 주어지면, 조합의 수를 계산해라.
// N 은 100만까지 가능. 
// K 는 1000만
// int 로 안될듯. 100만개에서 1억까지니까
// long 을 사용해함.
// n 이 100만이므로 2개의 요소를 선택할때 2중for문으로는 안됨. 
// -> 이분탐색 이용

class boj_9024 {

    public static int min;
    public static int count;
    public static int[] array;
    public static int N;
    public static int K;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        while(T-- > 0){

            st = new StringTokenizer(br.readLine());

             N = Integer.parseInt(st.nextToken());
             K = Integer.parseInt(st.nextToken());

            array = new int[N];
            st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<N;i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬을 진행.
            Arrays.sort(array);

            //그리고 그 반대의 수랑 가장 가까운 인덱스 찾기. 
            //두가지가 있을텐데 그거 2개를 비교하기
            // 그리고 그 결과 2개 비교한거 중에서 작은것 추가. 어디다가?
            // array 그냥 1000만부터 1000만까지 만들어버려서 추가.
            int prevMin =0;
            
            int left = 0, right = N - 1;
            long minDiff = Long.MAX_VALUE;
            int count = 0;

            while(left < right){
                long sum = (long) array[left] + array[right];

                long diff =  Math.abs(sum - K);
                
                if (diff < minDiff) {
                    minDiff = diff;
                    count = 1;
                } else if (diff == minDiff) {
                    count++;
                }

                if(sum < K){
                    left++;
                }
                else{
                    right--;
                }
            }
            
            
            System.out.println(count);
        }
    }

    
}
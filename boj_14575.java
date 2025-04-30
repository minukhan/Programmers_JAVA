import java.util.*;
import java.lang.*;
import java.io.*;


// 2:27
// 어느정도 마시면 기분이 좋은지 힘든지를 조사.
// T 의 술이 있다.
// 모든사람 I에게 L 이상 R 이하의 술을 따라주는것이 목적. 이때 총 합이 정확히 T
// 도현이는 S의 값을 정하고 그 사람이 원하는 술의 양이 얼마이던지 관계없이 S 이하의 술만을 주려고한다.
// 모든사람이 적절한 술을 받으면서 모든사람이 받은 술의 합은 T여야하고
// 어떤사람도 S를 초과하면 안된다. s 라고 정해뒀을때 모든사람에게 L이상 R 이하의 술을 줄 
// 수 있느냐. 
// N은 1,000 n제곱 log n 까지 가능
// 배열에 그럼 다 저장할꺼고 일단 사람들의 최소값을 찾아야겠네
// 그래야 S의 최소값이 나올꺼고 거기부터 증가시켜나가면서 T를 넘어가면 break
// 3 13
// 2 13
// 4 10
// 1 16
class boj_14575 {

    public static int N;
    public static int T;
    public static int[] minA;
    public static int[] maxA;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
         N = Integer.parseInt(st.nextToken());
         T = Integer.parseInt(st.nextToken());
        int L = Integer.MAX_VALUE;  // L의 최소값 초기화
        int R = 0;  // R의 최대값 초기화
        minA = new int[N];
        maxA = new int[N];
        int minSum =0;
        int maxSum =0;
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int minAl = Integer.parseInt(st.nextToken());
            int maxAl = Integer.parseInt(st.nextToken());
            L = Math.min(L, minAl);
            R = Math.max(L, maxAl);
            minSum += minAl;
            maxSum += maxAl;
            minA[i] = minAl;
            maxA[i] = maxAl;
        }

        if(maxSum < T || minSum > T){
            System.out.println(-1);
            System.exit(0);
        }

        int answer = binarySearch(L, T);
        
        System.out.println(answer);
    }

    public static int binarySearch(int L, int R){

        
        while(L <= R){
            int sum =0;
            
            int mid = L + (R-L)/2;
            boolean check = false;
            
            for(int i=0;i<N;i++){
                if(minA[i]>mid){
                    check=true;
                    break;
                }
                sum+=Math.min(maxA[i],mid);
            }

            if(check){
                 L = mid +1;
                continue;
            }

            if(sum >= T){
                R = mid -1;
            }
            else{
                L = mid +1;
            }
        }
        return L;
    }

}
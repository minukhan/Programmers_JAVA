import java.util.*;
import java.lang.*;
import java.io.*;
// 가깝다? -> 정렬을 생각해라.
        
class Eat_Eaten {

    public static BufferedReader br;
    
    public static void Eat_Eaten(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++){
            count();
        }
        
    }
        
    public static void count() throws IOException{

        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] AList = new int[N];
        int[] BList = new int[M];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            AList[i] = (Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;i++){
            BList[i] = (Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(AList);
        Arrays.sort(BList);

        for(int i=0;i<N;i++){
            int number = AList[i];
            answer += binarySearch(BList, 0, M-1, number);
        }

        
        System.out.println(answer);
        
    }

    public static int binarySearch(int[] array, int L, int R, int number){
        
        while(L<=R){
            int mid = L + (R - L) / 2;
            
            if(array[mid] < number){
                L = mid + 1;
            } 
            else if(array[mid] >= number){
                R = mid - 1;
            }
        }
        return L;
}
}


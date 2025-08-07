import java.util.*;
import java.lang.*;
import java.io.*;


// 햄버거 
// 원하는 조합으로 만들어서 준다.
// 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않도록 한다. 

// 햄버거 재료의 맛을 점수를 매겨놈
// 가게에서 제공하는 재료
// 정해진 칼로리 이하의 조합중에서 가장 선호하는 햄버거를 조합해주는 프로그램. 
// 재료의 수 20, 제한 칼로리 1000
// 다음 N개의 줄에는 재료에 대한 맛에 대한 점수, 칼로리 나타냄. 
// 주어진 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거 개수.


class HamburgerDiet {
    public static int N;
    public static int limit;
    public static int[] score;
    public static int[] weight;
    public static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int size = 1;
        
        while(T-- > 0){
            max = Integer.MIN_VALUE;
            
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            score = new int[N];
            weight = new int[N];
            
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());  
                weight[i] = Integer.parseInt(st.nextToken());  
            }

            dfs(0,0,0,0);

            System.out.println("#" + size + " " + max);

            size++;
        }
    }
    
    public static void dfs(int count, int index, int sum, int weightSum){

        if(weightSum <= limit){
            max = Math.max(sum, max);
        }

        if(weightSum >= limit){
            return;   
        }
        if(count == N){
            return;
        }

        for(int i=index;i<N;i++){
            dfs(count+1, i+1 ,sum + score[i], weightSum + weight[i]);
        }
    }

}
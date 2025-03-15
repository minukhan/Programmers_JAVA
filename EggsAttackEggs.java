import java.util.*;
import java.lang.*;
import java.io.*;

class EggsAttackEggs {

    public static int N;
    public static int max;
    public static int[] weight;
    public static int[] heart;
    
    public static void EggsAttackEggs(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


       N = Integer.parseInt(br.readLine());

        weight = new int[N];
        heart = new int[N];
        max = 0;
        
        StringTokenizer st;
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            heart[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        
        
        System.out.println(max);
    }

    public static void dfs(int index ,int count){

        if(index == N){ // 계란이 가장 오른쪽에 위치한 계란일때
            max = Math.max(max,count);
            return;
        }

        if(heart[index] <= 0){ // 내가 든 계란이 깨졌을때
            dfs(index +1, count);
            return;
        }
            
        boolean attackCheck = false; // 계란을 아무도 안쳤을 경우를 확인하는 변수
        
        for(int i=0;i<N;i++){
            if(heart[i] <= 0 || i==index) continue; // 때릴 계란이 깨져있거나 든 계란일때
            
            heart[index] = heart[index] - weight[i];
            heart[i] = heart[i] - weight[index];

            int brokenCount = count; // 백트래킹할때 count가 변하지 않도록 새로운 변수로 등록

            if(heart[index] <= 0) brokenCount++;
            if(heart[i] <= 0) brokenCount++;
            attackCheck = true;
            dfs(index +1, brokenCount);

            heart[index] = heart[index] + weight[i];
            heart[i] = heart[i] + weight[index];
        }

        if(!attackCheck){ // 다 깨져있을 경우 다음으로 넘어감.
            dfs(index + 1, count);
        }
        
        
    }

    
}
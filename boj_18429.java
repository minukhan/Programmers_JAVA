import java.util.*;
import java.lang.*;
import java.io.*;

// 10 : 56

// 3태 운동 500현재 500인듯. 
// 하루가 지날때마다 중량이 K만큼 감소
// 운동을 안하고 가만히 있으면 매일 감소함.
// N개의 운동키트가 있다. 하루에 1개씩 키트를 사용 -> 운동을 안하진 않네
// 어떤 키트를 사용할지는 맘대로 고르고 각각의 중량 증가량이 있다. 즉시 증가.
// 같은 키트들도 있는데 (증가량이 같다는말) 다른 운동키트로 간주.
// N 일동안 한번씩만 사용할 수 있음.
// 항상 500이상으로 유지하고싶음.
// 1~N 까지 모든 기간동안 500보다 작아지면 안됨. -> 가장 큰거부터 이용하면되는거 아닌가
// 하루에 1개씩 사용하는 모든경우중에서 500 이상이 되도록 하는 경우의수를 구해라.
// N과 K는 공백을 기준으로 주어져있음. N 은 8 이하, K는 50이하. K는 감소하는 중
// N 이 8밖에 안되니까 완탐 가능할듯. 다 완탐돌렸을때 되는 경우 count 하면 되는데?
// dfs 돌릴때 중복 허용 안하는 순열이네

class boj_18429 {

    public static int N;
    public static int answer =0;
    public static int K;
    public static int[] weight;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        weight = new int[N];
        
        for(int i=0;i<N;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,500);

        System.out.println(answer);
        
    }
    public static void dfs(int count, int current){
        if(count ==N){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){

            int value = current - K + weight[i];
            int temp = weight[i];
            
            if(value < 500) continue;
            if(weight[i] == 0) continue;

            weight[i] = 0;
            dfs(count +1, value);
            weight[i] = temp;

        }
    }
}
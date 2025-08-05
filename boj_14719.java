
import java.util.*;
import java.lang.*;
import java.io.*;

// 9 : 32

// 2차우너 세계에 블록이 쌓여있다. 
// 비가오면 블록 사이에 빗물이 고인다. 
// 충분이 많이오고, 고이는 빗물의 총 량.
// 세로 길이, 가로길이가 주어짐. 500까지.
// 블록의 높이가 주어짐. 
// 바닭은 항상 막혀있고.
// 일단 고이려면. 양 끝을 봐야함.
// 큰값을 찾아라? left 랑 right 랑 큰 값을 찾아야지.
// 인접한경우, 인접하지 않은 경우.
// 기울기가 변할경우?
// 하나의 지점에서 크거나 같은점을 찾아? 
// 배열로 관리해도됨. 물 차있는거
// 일단 하나 골랐을때, 크거나 같아야함. 내려가도 그 사이가 고여있으면 가능.
// max, min

// 경우의수.
// 1을 골랐을때, 감소하는경우.
// 1을 골랐을때, 증가하는경우.
// 증가하다가 감소. 불가능. 계속 증가만했으면 그 구간은 버림. 
// 다시 시작. 
// 감소하다가 증가? 이떄 경우의수가 생김. 
// 근데 어디까지? 또 변곡될떄? 같아도 됨. 
// 일단 물이 고이려면 감소하다가 증가.
// 증가하다가 감소하면 그 나머지 인덱스 버리기.
// 이게 맞는듯. 
// 그리고 감소하다가 증가하면 계속 증가할때까지 가다가. 다시 내려갈때 종료.
// 이때 처음 감소할때랑 지금 감소할떄 비교. 그렇게 count 해나가면 될듯. 


class boj_14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] block = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i=1;i<N-1;i++){

            int leftMax = Integer.MIN_VALUE;
            int L = i-1;
            while( L >= 0){
                leftMax = Math.max(leftMax, block[L]);
                L--;
            }

            int rightMax = Integer.MIN_VALUE;
            int R = i+1;
            while( R <= N-1){
                rightMax = Math.max(rightMax, block[R]);
                R++;
            }

            int result = Math.min(leftMax, rightMax) - block[i];

            if(result <= 0) continue;
            
            sum += result;
        }

        System.out.println(sum);

        
    }
}





























import java.util.*;
import java.lang.*;
import java.io.*;

// 4 :23
// 인간이 거주할 수 있는 행성을 찾으려한다.
// 정글, 바다, 얼음이 뒤얽혀있는 행성.
// 가로 N, 세로 M 인 직사각형 모형.
// 각 구역의 지형이 알파벳으로 표시되어있다. 
// 정글은 J
// 바다는 O
// 얼음은 I
// 로 되어있다. 
// 조사대상 영역을 K 개 만들었다/ 
// 각 영역에 몇개씩 있는지 구하는 프로그램?
// 1000 * 1000 까지 만들어진다. 
// 조사 대상 영역의 갯수 K 가 주어진다. 
// 3째 줄부터 M 개 줄에는 상근이가 보낸 지도의 내용. 
// 왼쪽위 모서리좌표, 오른쪽 아래 모서리 좌표.
// K가 근데 10만까지 있네. 흠.. 
// 다 돌려보면 당연히 시간초과.
// 이것도 누적합으로 처리하면 되는거 아닌가? 
// I의 누적합 배열, O의 누적합배열, J 의 누적합배열. 

class boj_5549 {

    public static int[][] dp1;
    public static int[][] dp2;
    public static int[][] dp3;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        int K = Integer.parseInt(br.readLine());
        
        // 시작점은 1,1
        char[][] road = new char[N+1][M+1];
        for(int i=1;i<N+1;i++){
            String input = br.readLine();
            for(int j=1;j<M+1;j++){
                road[i][j] = input.charAt(j-1);
            }
        }


        dp1 = new int[N+1][M+1];
        dp2 = new int[N+1][M+1];
        dp3 = new int[N+1][M+1];

        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                
                switch(road[i][j]){
                    case 'O':
                        dp2[i][j] = 1;
                        break;
                    case 'J':
                        dp1[i][j] = 1;
                        break;
                    case 'I':
                        dp3[i][j] = 1;
                        break;
                }
                
                dp1[i][j] = dp1[i][j] + dp1[i][j-1] + dp1[i-1][j] - dp1[i-1][j-1];
                dp2[i][j] = dp2[i][j] + dp2[i][j-1] + dp2[i-1][j] - dp2[i-1][j-1];
                dp3[i][j] = dp3[i][j] + dp3[i][j-1] + dp3[i-1][j] - dp3[i-1][j-1];
            }
        }

        
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());

            int sY = Integer.parseInt(st.nextToken());
            int sX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            
            int[] answer = count(sY, sX, eY,eX);


            for(int j=0;j<3;j++){
                sb.append(answer[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
    public static int[] count(int startY, int startX, int endY, int endX){
        // 1: 정글 2: 바다 3: 얼음
        int[] answer = new int[3];

        answer[0] = dp1[endY][endX] - dp1[startY-1][endX] - dp1[endY][startX - 1] + dp1[startY -1][startX-1];
        answer[1] = dp2[endY][endX] - dp2[startY-1][endX] - dp2[endY][startX - 1] + dp2[startY -1][startX-1];
        answer[2] = dp3[endY][endX] - dp3[startY-1][endX] - dp3[endY][startX - 1] + dp3[startY -1][startX-1];
        
        return answer;
    }
}





























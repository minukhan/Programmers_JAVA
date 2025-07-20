import java.util.*;
import java.lang.*;
import java.io.*;



class boj_6987 {
    public static int[][] result = {{0,1},
                                      {0,2},
                                      {0,3},
                                      {0,4},
                                      {0,5},
                                      {1,2},
                                      {1,3},
                                      {1,4},
                                      {1,5},
                                      {2,3},
                                      {2,4},
                                      {2,5},
                                      {3,4},
                                      {3,5},
                                      {4,5}};
    public static int[][] input;
    public static int[][] current;
    public static boolean check;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true){
            
            input = new int[6][3];
            current = new int[6][3];
            
            String in = br.readLine();
            if(in == null) break;
            
            st = new StringTokenizer(in);
            
            for(int i=0;i<6;i++){
                for(int j=0;j<3;j++){
                    input[i][j] = Integer.parseInt(st.nextToken());
                    current[i][j] = 0;
                }
            }
            // 1) 기본 검증: 팀마다 5경기씩, 전체 합도 30
            check = true;
            int total = 0;
            for (int i = 0; i < 6; i++) {
                int sum = input[i][0] + input[i][1] + input[i][2];
                if (sum != 5) { check = false; break; }
                total += sum;
            }
            if (!check || total != 30) {
                sb.append("0 ");
                continue;
            }
            
            dfs(0);

            if(!check){
                sb.append("1").append(" ");
            } 
            else{
                sb.append("0").append(" ");
            }

            
        }
        System.out.println(sb.toString());
        
    }

    public static void dfs(int count){

        if(count == 15){
            check = false;
            return;
        }

        if(!check){
            return;
        }

        int front = result[count][0];
        int back = result[count][1];
        
        // 앞사람이 이기는 경우
        if(current[front][0] + 1 <= input[front][0] && current[back][2] + 1 <= input[back][2]){
            current[front][0]++;
            current[back][2]++;

            dfs(count + 1);
            
            current[front][0]--;
            current[back][2]--;
        }
            
        // 뒷사람이 이기는경우
        if(current[front][2] + 1 <= input[front][2] && current[back][0] + 1 <= input[back][0]){
            current[front][2]++;
            current[back][0]++;

            dfs(count + 1);
            
            current[front][2]--;
            current[back][0]--;
        }
        
        // 비기는 경우
        if(current[front][1] + 1 <= input[front][1] && current[back][1] + 1 <= input[back][1]){
            current[front][1]++;
            current[back][1]++;
            dfs(count + 1);
            current[front][1]--;
            current[back][1]--;
        }
    }
}


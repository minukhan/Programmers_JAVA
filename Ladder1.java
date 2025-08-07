import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    
    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static Node start;
    public static int[] dx = {-1,1,0};
    public static int[] dy = {0,0,-1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int index =0;
        int[][] road;
        
        String input;
        while((input = br.readLine()) != null){

            index = Integer.parseInt(input);

            road = new int[100][100];
            
            for(int i=0;i<100;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++){
                    road[i][j] = Integer.parseInt(st.nextToken());
                    if(road[i][j] == 2) start = new Node(i, j);
                }
            }
            
            int x = start.x;
            int y = start.y;
            int nx = 0;
            int ny = 0;
            // 1이면 왼쪽 2면 오른쪽 3이면 위쪽 
            int prevAction = 0;
            int answer =0;
            
            while(true){
                
                boolean left = true;
                boolean right = true;
                boolean up = true;
    
                if(y == 0){
                    answer = x;
                    break;
                }
    
                // 왼쪽이 1이면. 
                 nx = x + dx[0];
                 ny = y + dy[0];
    
                // 만약 범위 밖이라면 
                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100){
                    left = false;
                }
                else{ // 만약 범위 안이라면
                    if(road[ny][nx] != 1){
                        left = false;
                    }
                }
                
                // 오른쪽이 1이면. 
                 nx = x + dx[1];
                 ny = y + dy[1];
                
                // 만약 범위 밖이라면 
                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100){
                    right = false;
                }
                else{ // 만약 범위 안이라면
                    if(road[ny][nx] != 1){
                        right = false;
                    }
                }
    
                // 위쪽이 1이면. 
                 nx = x + dx[2];
                 ny = y + dy[2];
    
                // 만약 범위 밖이라면 
                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100){
                    up = false;
                }
                else{ // 만약 범위 안이라면
                    if(road[ny][nx] != 1){
                        up = false;
                    }
                }
    
                // 만약 왼쪽 길이 있다면 진행. 
                if(left){
                    road[y][x] = 0;
                    
                    x = x + dx[0];
                    y = y + dy[0];
                    
                    continue;
                }
                else if(right){ // 오른쪽 길이 있다면 
                    road[y][x] = 0;
                    
                    x = x + dx[1];
                    y = y + dy[1];
                    continue;
                }
                else{
                    road[y][x] = 0;
                    
                    x = x + dx[2];
                    y = y + dy[2];
                    continue;
                }
                    
            }


            System.out.println("#"+ index + " " + answer);
        }
        

        
    }
}
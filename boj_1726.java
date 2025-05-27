import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1726 {

    static class Node{
        int y;
        int x;
        int distance;
        int count;
        public Node(int y, int x, int distance, int count){
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.count = count;
        }
    }

    public static Node start;
    public static Node end;
    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][][] visited;
    
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken()); 
         M = Integer.parseInt(st.nextToken()); 

        map = new int[N][M];
        visited = new int[N][M][5];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()),0);
        st = new StringTokenizer(br.readLine());
        end = new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()),0);

        bfs();
        
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited[start.y][start.x][start.distance] = 1;

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if(node.x == end.x && node.y == end.y && node.distance == end.distance){
                System.out.println(node.count);
                return;
            }

            // 움직일 수 있는 가짓수 1칸움직이기, 2칸움직이기, 3칸움직이기, 오른쪽 회전, 왼쪽회전
            switch(node.distance){
                case 1: // 동쪽
                    for(int i=1;i<4;i++){

                        int nx = node.x + i;
                        int ny = node.y;
        
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) break;
                        if(visited[ny][nx][1] == 1) continue;
                        if(map[ny][nx] == 1) break;
        
                        queue.add(new Node(ny,nx,1,node.count + 1));
                        visited[ny][nx][1] = 1;
                    
                    }
                    // 왼쪽 회전
                    if(visited[node.y][node.x][4] != 1){
                        queue.add(new Node(node.y,node.x,4,node.count + 1));
                        visited[node.y][node.x][4] = 1;
                    }
                    
                    // 오른쪽 회전
                    if(visited[node.y][node.x][3] != 1){
                        queue.add(new Node(node.y,node.x,3,node.count + 1));
                        visited[node.y][node.x][3] = 1;
                    }
                    break;
                case 2: // 서쪽
                    for(int i=1;i<4;i++){

                        int nx = node.x - i;
                        int ny = node.y;
        
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) break;
                        if(visited[ny][nx][2] == 1) continue;
                        if(map[ny][nx] == 1) break;
        
                        queue.add(new Node(ny,nx,2,node.count + 1));
                        visited[ny][nx][2] = 1;
                        
                    }
                    // 오른쪽 회전
                    if(visited[node.y][node.x][4] != 1){
                        queue.add(new Node(node.y,node.x,4,node.count + 1));
                        visited[node.y][node.x][4] = 1;
                    }
                    
                    // 왼쪽 회전
                    if(visited[node.y][node.x][3] != 1){
                        queue.add(new Node(node.y,node.x,3,node.count + 1));
                        visited[node.y][node.x][3] = 1;
                    }
                    break;
                case 3: // 남쪽
                    for(int i=1;i<4;i++){

                        int nx = node.x;
                        int ny = node.y + i;
        
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) break;
                        if(visited[ny][nx][3] == 1) continue;
                        if(map[ny][nx] == 1) break;
        
                        queue.add(new Node(ny,nx,3,node.count + 1));
                        visited[ny][nx][3] = 1;
                        
                    }
                    // 왼쪽 회전
                    if(visited[node.y][node.x][1] != 1){
                        queue.add(new Node(node.y,node.x,1,node.count + 1));
                        visited[node.y][node.x][1] = 1;
                    }
                    
                    // 오른쪽 회전
                    if(visited[node.y][node.x][2] != 1){
                        queue.add(new Node(node.y,node.x,2,node.count + 1));
                        visited[node.y][node.x][2] = 1;
                    }
                    break;
                case 4: // 북쪽
                    for(int i=1;i<4;i++){

                        int nx = node.x;
                        int ny = node.y - i;
        
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) break;
                        if(visited[ny][nx][4] == 1) continue;
                        if(map[ny][nx] == 1) break;
                        
                        queue.add(new Node(ny,nx,4,node.count + 1));
                        visited[ny][nx][4] = 1;
                    }
                    // 왼쪽 회전
                    if(visited[node.y][node.x][2] != 1){
                        queue.add(new Node(node.y,node.x,2,node.count + 1));
                        visited[node.y][node.x][2] = 1;
                    }
                    
                    // 오른쪽 회전
                    if(visited[node.y][node.x][1] != 1){
                        queue.add(new Node(node.y,node.x,1,node.count + 1));
                        visited[node.y][node.x][1] = 1;
                    }
                    break;
            }
        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

// 3: 31

// 10 * 9 장기판을 나타낸다. 
// 왕의 위치가 정해져있고 상의 위치가 정해져있다.
// 이떄 상이 움직이면서 도달할 수 있는 최소 이동횟수를 구해라. 
// 다행이 기물이 있지는 않네. 그러면 완탐? 최소니까 BFS? 인듯한데?
// 도달했다면 break. 
// 격자칸을 하나 만들고 거기서 위치는 dx, dy 로 기록해놓으면 될듯. 

class boj_16509 {
    
    static class Node{
        int y;
        int x;
        int count;
        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public static int answer=-1;
    public static Node start;
    public static Node end;
    public static int[][] visited;
    public static int[][][] move = {
        {{-1, 0}, {-2, -1}, {-3, -2}}, // 왼쪽 위
        {{-1, 0}, {-2, 1}, {-3, 2}},   // 오른쪽 위
        {{1, 0}, {2, -1}, {3, -2}},    // 왼쪽 아래
        {{1, 0}, {2, 1}, {3, 2}},      // 오른쪽 아래
        {{0, -1}, {-1, -2}, {-2, -3}}, // 위쪽 왼쪽
        {{0, -1}, {1, -2}, {2, -3}},   // 아래쪽 왼쪽
        {{0, 1}, {-1, 2}, {-2, 3}},    // 위쪽 오른쪽
        {{0, 1}, {1, 2}, {2, 3}},      // 아래쪽 오른쪽
    };
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
        st = new StringTokenizer(br.readLine());
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);

        visited = new int[10][9];
        
        bfs();

        System.out.println(answer);
        
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited[start.y][start.x] = 1;

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if(node.y == end.y && node.x == end.x){
                answer = node.count;
                return;
            }

            for(int[][] mo : move){ // 8가지의 갈림길

                int y1 = node.y + mo[0][0], x1 = node.x + mo[0][1];
                int y2 = node.y + mo[1][0], x2 = node.x + mo[1][1];
                int y3 = node.y + mo[2][0], x3 = node.x + mo[2][1];
    
                if(x1 < 0 || x1 >= 9 || y1 < 0 || y1 >= 10) continue;
                if(x2 < 0 || x2 >= 9 || y2 < 0 || y2 >= 10) continue;
                if(x3 < 0 || x3 >= 9 || y3 < 0 || y3 >= 10) continue;
                
                // 중간 경유지에 왕이 있으면 불가
                if ((y1 == end.y && x1 == end.x)) continue;
                if ((y2 == end.y && x2 == end.x)) continue;
    
                if (visited[y3][x3] == 1) continue;

                visited[y3][x3] = 1;
                queue.add(new Node(y3, x3, node.count + 1));
            }
        }
                
    }
   
}
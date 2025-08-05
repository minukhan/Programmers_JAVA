
import java.util.*;
import java.lang.*;
import java.io.*;

// 1: 15
// 개구리의 여행. 
// N * N 크기의 정사각형 형태로 돌이 있다. 
// 개구리는 돌 위에서 돌아다닐 수 있다. 
// 위험한 돌이 있다. 
// 안전한돌, 미끄러운 돌, 천적이 사는 돌. 
// . 이면 안전한돌, S 면 미끄러운돌, #이라면 천적이 사는 돌. 
// 초기 점프력은 1이며 행동을 3개 할 수 있다. 
// 1. 점프. 상하좌우로 점프한다. 
// 이동하려는 위치에 돌이 없을 수 있어? 돌이없으면 이동 불가능. 
// 미끄러운 돌이 있다면 위험하기 때문에 이동 못감. 
// 천적이 사는 돌도 매우 위험해서 지나치는 경로로도 못씀.
// 점프에는 1만큼의 시간이 소요된다. 
// 점프력을 증가시킬 수 있다.
// 점프력 감소. 
// 점프력 만약 5였으면 바로 1~5까지 감소시킬 수 있다. 
// 점프력 증가는 5까지만 증가시킬 수 있음. 
// 점프력 증가 후 점프력을 k 라고 할때 k제곱만큼의 시간이 소요된다. 
// 최대한 빠른 시간안에 여행을 마치고싶다. 
// 첫줄에 정수 N 이 주어진다. 
// 3초.

// 시간복잡도 
// 3초임. 점프력 증가를 다 할 수 있게? 
// 이것도 약간 다익스트라처럼 더 짧은 값을 가지고있을때만 가면 좋을듯.
// 이게 50이니까 터질만함. 
// visited 를 사용하면 안됨. 다시 돌아와야 할 이유가있을까? 
// 없으면 그냥 사용해도 됨. 
// 만약 방문체크를 할꺼면 점프력과, 위치로 하는게 맞나?
// 아니지. 다른방법으로 더 빠르게 올 수 있으니까. visited 로 하는데. 그곳에는 dist 를 둬야함. 
// 가중치가 1이기때문에 BFS 로 문제를 해결하면 될듯. 

// 주의

// 미끄러운돌은 그냥 그 위치만 판단하면됨. 그러나 천적이 사는돌은 지나치는 경로도 못감. 
// 도착이 불가능하면 -1 출력. 

public class FlagTravel {

    static class Node{
        int y;
        int x;
        int count; // 시간초 계산 
        int power;
        public Node(int y, int x, int count, int power){
            this.y = y;
            this.x = x;
            this.count = count; 
            this.power = power;
        }
    }
    public static int[][][] visited;
    public static int[][] road;
    public static int N;
    public static int min;
    public static int[] dx;
    public static int[] dy;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
         N = Integer.parseInt(br.readLine());

        // 0이면 가능, 1이면 미끄러운돌, 2면 천적. 
        road = new int[N][N];
        visited = new int[6][N][N];


        for(int i=0 ;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                char c = input.charAt(j);
                int value = 0;

                switch(c){
                    case '.':
                        value = 0;
                        break;
                    case '#':
                        value = 2;
                        break;
                    case 'S':
                        value = 1;
                        break;
                }
                road[i][j] = value;
            }
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            Node start = new Node(startY, startX, 0, 1);
            Node end = new Node(endY, endX, 0, 1);

            init();

            bfs(start , end);

            int answer = (min == Integer.MAX_VALUE) ? -1 : min;

            System.out.println(answer);
        }

    }
    public static void init(){
        min = Integer.MAX_VALUE;
        visited = new int[6][N][N];

        for(int[][] arr : visited){
            for(int[] value : arr){
                Arrays.fill(value, Integer.MAX_VALUE);
            }
        }

    }
    public static void bfs(Node start, Node end){
        
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.count, o2.count)
        );

        queue.add(start);
        visited[1][start.y][start.x] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            // 현재 노드가 최소 노드인지 판단. 
            if(visited[node.power][node.y][node.x] != node.count) continue;
            
            if(node.y == end.y && node.x == end.x){
                min = Math.min(min, node.count);

                continue;
            }

            // 점프력 증가시키기
            int distPower = node.count;
            for(int i=node.power+1;i<6;i++){
                
                distPower += i * i;
                if(visited[i][node.y][node.x] <= distPower) continue;

                // visited 배열을 거리 배열로 사용, 점프력은 증가량 * 증가량 만큼 증가시켜야함. 
                queue.add(new Node(node.y, node.x, distPower, i));
                visited[i][node.y][node.x] = distPower;
            }

            // 점프력 감소하기. 1~K 까지 가능.
            for(int i=node.power-1;i>=1;i--){
                int dist = 1 + node.count;

                if(visited[i][node.y][node.x] <= dist) continue;

                queue.add(new Node(node.y, node.x, dist, i));
                visited[i][node.y][node.x] = dist;
            }

            // 이동하기

            // dx, dy 값 바꾸는 함수.
            initPower(node.power);

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];


                if(ny < 0 || ny >=N || nx < 0 || nx >= N) continue;
                
                if(road[ny][nx] != 0) continue;

                // 가는 도중에 천적이 있을경우. 
                // 남 북 서 동  
                if(i==0){
                    boolean check = true;
                    for(int j=node.y+1;j<ny;j++){
                        if(road[j][nx] == 2) check = false; 
                    }
                    if(!check) continue;
                }
                else if(i==1){
                    boolean check = true;       
                    for(int j=node.y-1;j>ny;j--){
                        if(road[j][nx] == 2) check = false; 
                    }
                    if(!check) continue;
                }
                else if(i==2){
                    boolean check = true;       
                    for(int j=node.x-1;j>nx;j--){
                        if(road[ny][j] == 2) check = false; 
                    }
                    if(!check) continue;
                }
                else{
                    boolean check = true;       
                    for(int j=node.x+1;j<nx;j++){
                        if(road[ny][j] == 2) check = false; 
                    }
                    if(!check) continue;
                }

                // 마지막관문 visited 값이 더 작은경우.
                if(visited[node.power][ny][nx]  > node.count+1){
                    visited[node.power][ny][nx] = node.count + 1;
                    queue.add(new Node(ny,nx, node.count + 1, node.power));
                }


            }


        }


    }
    // 남 북 서 동 
    public static void initPower(int power){
        int[] nextDx = {0, 0, -1*power, 1*power};
        int[] nextDy = {1*power,-1*power, 0,0,};
        dx = nextDx;
        dy = nextDy;
    }
}

















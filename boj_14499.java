
import java.util.*;
import java.lang.*;
import java.io.*;

// 10 : 03

// 크기가 N M 인 지도가 존재한다.
// 오른쪽 동쪽, 위쪽 북쪽.
// 주사위가 주어지고 전개도가 주어짐.
// 주사위의 초기 상태는 윗면이 1, 동쪽을 바라보는 방향이 3.
// x,y \에 놓여져 있다고 한다.
// 처음에는 주사위 모든면에 0이 적혀져있다고 함. 
// 지도의 각 칸에는 하나씩 쓰여져있고 숫자가.
// 주사위를 굴렸을때 이동한칸에 쓰여있는 수가 0이면 주사위 바닥면에 있는 수가 복사됨. 
// 0이 아니라면 칸의 수가 주사위로 복사. 칸은 0이 된다. 일회성. 
// 주사위를 놓은 곳의 좌표와 이동명령이 주어짐, 이동했을때 상단에 쓰여있는 값을 구해라. 
// 그 과정들을 다 기록해놔야 가능하겠지.
// 가로 세로 20까지 가능. 
// 명령은 1000개 까지 가능. 
// 이동할때마다 윗면에 쓰여있는 수를 출력해라.
// 그냥 구현인듯? 시간초과 날 건덕지는 안보이고. 
// 주사위를 어떻게 기록할까? 
// 배열? 오른쪽 이동할때 어떻게 바뀌고, 왼쪽 이동할때 어떻게 바뀌고 그거 다 저장해놓고 하면 되는거아님?



// ####

// 지도를 0으로 바꿔줘야함 일회성!
// 바깥으로 이동하려는 경우는 무시해야함 범위체크.
// 지도가 0 이면 주사위에 있는 숫자를 복사, 지도가 0이 아니면 주사위에 복사. 그냥 객체로 관리하는게 나을듯.

class boj_14499 {
    public static int N;
    public static int M;
    public static int X;
    public static int Y;
    public static int K;
    public static int[][] road;
    
    static class Node{
        int y;
        int x;
        int up;
        int down;
        int right;
        int left;
        int front;
        int back;
        public Node(int y, int x, int up, int down, int right, int left, int front, int back){
            this.x = x;
            this.y = y;
            this.up = up;
            this.down = down;
            this.right = right;
            this.left = left;
            this.front = front;
            this.back = back;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         Y = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

        road = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Node current = new Node(Y,X,0,0,0,0,0,0);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            // 명령들별로 처리.
            int index = Integer.parseInt(st.nextToken());
            
            switch(index){
                case 1: // 동
                    if(current.x + 1 >= M) continue;
                    current = moveRight(current);
                    System.out.println(current.up);
                    break;
                case 2: // 서
                    if(current.x - 1 < 0) continue;
                    current = moveLeft(current);
                    System.out.println(current.up);
                    break;
                case 3: // 북
                    if(current.y - 1 < 0) continue;
                    current = moveUp(current);
                    System.out.println(current.up);
                    break;
                case 4: // 남
                    if(current.y + 1 >= N) continue;
                    current = moveDown(current);
                    System.out.println(current.up);
                    break;
            }
        }
    }

    //동
    public static Node moveRight(Node current){
        int x = current.x + 1;
        int y = current.y;
        int up = current.left;
        int down = current.right;
        int right = current.up;
        int left = current.down;
        int front = current.front;
        int back = current.back;

        if(road[y][x] == 0){
            road[y][x] = down;
        }
        else{
            down = road[y][x];
            road[y][x] = 0;
        }

        return new Node(y,x,up,down,right,left,front,back);
    }
    // 서
    public static Node moveLeft(Node current){
        int x = current.x -1;
        int y = current.y;
        int up = current.right;
        int down = current.left;
        int right = current.down;
        int left = current.up;
        int front = current.front;
        int back = current.back;

        if(road[y][x] == 0){
            road[y][x] = down;
        }
        else{
            down = road[y][x];
            road[y][x] = 0;
        }

        return new Node(y,x,up,down,right,left,front,back);
    }
    // 북
    public static Node moveUp(Node current){
        int x = current.x;
        int y = current.y - 1;
        int up = current.back;
        int down = current.front;
        int right = current.right;
        int left = current.left;
        int front = current.up;
        int back = current.down;

        if(road[y][x] == 0){
            road[y][x] = down;
        }
        else{
            down = road[y][x];
            road[y][x] = 0;
        }

        return new Node(y,x,up,down,right,left,front,back);
    }
    // 남
    public static Node moveDown(Node current){
        int x = current.x;
        int y = current.y + 1;
        int up = current.front;
        int down = current.back;
        int right = current.right;
        int left = current.left;
        int front = current.down;
        int back = current.up;

        if(road[y][x] == 0){
            road[y][x] = down;
        }
        else{
            down = road[y][x];
            road[y][x] = 0;
        }

        return new Node(y,x,up,down,right,left,front,back);
    }
}































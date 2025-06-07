import java.util.*;
import java.lang.*;
import java.io.*;

// 11:03
// 적의 공격에 대비해서 도시를 방어하는 게임
// 도시에는 탑이 N개가 있다. 
// X-Y 평면위에 존재함.
// D의 에너지를 가지고있다.
// R의 사정거리를 가지고있는 타워임
// 탑이 공격을 하는데 에너지를 재분배 가능. 2개의 탑의 거리가 R보다 작다면 
// 둘중의 한 타워는 다른 타워에게 에너지를 전송할 수 있음. 
// 이때 에너지를 전송할때 절반을 잃는다. 손실이 있음. 
// 적이 R 이내에 들어와야지만 공격을 할 수 있음. 
// 적이 받을 수 있는 에너지의 최대값을 구해라?
// 적은 단 하나인데? 
// N < 50 : 타워의 갯수
// R < 500 : 사정거리
// D < 100 : 초기에너지
// X,Y < 1,000 : 적의 좌표
// class 에 count 를 기록해놓고
// depth 가 깊어지면 2의 거듭제곱만큼 나누기. 그리고 더함. 

class boj_1430 {
    static class Node{
        int y;
        int x;
        int count;
        int index;
        public Node(int y, int x, int count, int index){
            this.y = y;
            this.x = x;
            this.count= count;
            this.index = index;
        }
    }
    public static int N;
    public static int R;
    public static int D;
    public static Node target;
    public static ArrayList<Node> list;
    public static Queue<Node> queue;
    public static double answer;
    public static int[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        visited = new int[N];
        
        target = new Node(y,x,0,-1);
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());
            list.add(new Node(nextY,nextX, 0, i));
        }

        bfs();
        System.out.println(Math.round(answer * 100) / 100.0);
    }

    public static void bfs(){
        queue = new LinkedList<>();
        init();

        while(!queue.isEmpty()){
            Node node = queue.poll();

            answer = answer + (double)D / Math.pow(2, node.count); 
            check(node);
        }
        
    }

    public static void init(){

        for(int i=0;i<N;i++){
            Node node = list.get(i);

            int x = node.x;
            int y = node.y;
            double result = Math.sqrt(Math.pow(Math.abs(target.x - x),2) + Math.pow(Math.abs(target.y - y),2));

            if(result <= R){
                queue.add(new Node(y, x, 0, node.index));
                visited[node.index] = 1;
            }
        }
    }

    public static void check(Node currentNode){

        for(int i=0;i<N;i++){
            Node node = list.get(i);

            if(visited[i] == 1) continue;
            
            int x = node.x;
            int y = node.y;

            double result = Math.sqrt(Math.pow(Math.abs(currentNode.x - x),2) + Math.pow(Math.abs(currentNode.y - y),2));

            if(result <= R){
                queue.add(new Node(y, x, currentNode.count + 1, node.index));
                visited[node.index] = 1;
            }
        }
    }
}



















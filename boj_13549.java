import java.util.*;
import java.lang.*;
import java.io.*;



// 12:17
// 숨바꼭질을 하는데 현재 점 N에 있고 동생은 K 에 있다. 걷거나 순간이동을 할 수 있음.
// 걷는다면 X-1, X+1, 순간이동하는 경우에는 0초가 걸림. 그리고 2*X 로 이동가능.
// 빽트래킹으로 하면 너무 오래걸리려나? ㅇㅇ 너무 많아서 오래걸리겠네 경우가 너무많음
// 그리고 최솟값이니까 빠르게 바로 도착하는걸 찾는 BFS 가 맞겠네 
// 그러면 순간이동한거는 앞에다가 넣으면 되겠는데? 0초니까 바로 넣어서 음. 일단.
// 횟수니까 ㅇㅇ 하나의 큐에 하나의 while 문만 사용하면 될 것 같고 딱 찾으면 break 하면
// 되겠다. 그러면 앞에도 넣을 수 있는 dequeue 를 사용하면 될듯.?
// Deque 를 이용하면 됨. 똑같이 LinkedList<> 선언하면 될 것 같고 ArrayDeque
// add, poll 똑같이 작용하고 대신 앞에다가 꽂거나 뺄때 addFirst pollFirst 오케이
// 근데 계속 2배로 가는걸 앞에 넣으면 무한이 동작할듯? 그래서 조건을 걸어야할듯.
// deque 를 써도 되고 우선순위 큐를 써도 되겠네

class boj_13549 {

    public static int N;
    public static int K;
    public static int count=0;
    public static int[] visited;

    static class Node{
        int n;
        int count;
        public Node(int n,int count){
            this.n = n;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[200000];

        bfs();
    }
    
    public static void bfs(){

        Deque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(N,0));
        visited[N] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int current = node.n;

            if(current == K){
                System.out.println(node.count);
                System.exit(0);
            }

            if(current < K && visited[current*2] == 0){
                queue.addFirst(new Node(current * 2, node.count));
                visited[current*2] = 1;
            }

            if(current-1 >=0 && visited[current-1] ==0){
                queue.add(new Node(current - 1, node.count+1));
                visited[current-1] = 1;
            }

            if(current+1 <= K && visited[current+1] ==0){
                queue.add(new Node(current +1, node.count+1));
                visited[current+1] = 1;
            }

        }
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

//10 : 27

//N * M 격자판 위에서 진행되고 각 칸은 비어있거나 막혀있다.
// 각 플레이어는 하나 이상의 성을 가지고있고 이 성도 격자판 위에 있음. 
// 한칸 위에 성이 2개 이상인경우는 없고
// 게임은 라운드로 이루어져있고 플레이어는 자기턴에 확장을 할 수 있음.
// 플레이어 1이 확장 그리고 2가 확장 bfs 로 1, 2 로 채워나가면 되는거아닌가?
// 최종 상태를 구하라고 함. visited 배열 다 출력?
// 격자판의 크기 N , M 그리고 플레이어수 P가 주어진다.
// 1000 까지 격자가 가능, P는 9까지 
// 1일때는 그렇게 하면 되는데 지금 1이 아니라 플레이어 별로 확장시킬때
// 이동할 수 있는 칸의 갯수가 다름. 그게 1억개까지 가능하대.
// BFS를 돌리면..? 1억인데 어짜피 격자가 1,000,000 개까지 가능하니까 최악이여도
// 1,000,000 이네 BFS 돌리면 될것같고 그러면 여러번 돌려야한다는말?
// queue에 넣을때 x,y 는 있을거고 status, 있을꺼고 반복을 어떻게할까?
// bfs? dfs? 로 한번 더 타고 들어가야할듯? 함수를 만들어서 위치를 쫙 뽑아
// 그리고 for문으로 돌린다? 근데 그러면 메모리초과가 안나나?

class boj_16920 {

    static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public static int N;
    public static int M;
    public static int P;
    public static int[] count;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1, 0, 0};
    public static int[][] road;
    public static int[][] visited;
    static Queue<Node>[] queues;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        count = new int[P+1];
        for(int i=1;i<=P;i++){
            count[i] =  Integer.parseInt(st.nextToken());
        }
        road = new int[N][M];
        visited = new int[N][M];
        queues = new LinkedList[P+1];
        for(int i=1;i<P+1;i++){
            queues[i] = new LinkedList<>();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j=0;j<M;j++){
                if(input.charAt(j) == '.'){
                    road[i][j] = 0;
                    continue;
                }
                if(input.charAt(j) == '#'){
                    road[i][j] = -1;
                    continue;
                }
                
                road[i][j] = input.charAt(j) - '0';
                queues[road[i][j]].add(new Node(j,i,0));
            }
        }

        bfs();

        int[] answer = new int[P+1];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(road[i][j] == -1) continue;
                if(road[i][j] == 0) continue;
                answer[road[i][j]]++;
            }
        }

        for(int i=1;i<P+1;i++){
            System.out.print(answer[i] + " ");
        }
    }

    public static void bfs(){
        boolean check = true;
        
        while(check){
            check = false;
            for(int i=1;i<P+1;i++){
                Queue<Node> current = queues[i];
                Queue<Node> next = new LinkedList<>();
                while(!current.isEmpty()){
    
                    Node node = current.poll();
        
                    if(node.count == count[i]) {
                        next.add(new Node(node.x, node.y, 0));
                        continue;
                    }

                    for(int k=0;k<4;k++){
                        int nx = node.x + dx[k];
                        int ny = node.y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        if(road[ny][nx] != 0) continue;

                        road[ny][nx] = i;
                        current.add(new Node(nx, ny, node.count + 1));
                        check = true;
                        
                    }
                }
                queues[i] = next;
            }
            
        }
        
    }

    
}
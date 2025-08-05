
import java.util.*;
import java.lang.*;
import java.io.*;

// 12 : 51

// 1부터 N 까지 번호가 붙여저 있는 학생들에 대해 키를 비교한 결과가 주어짐. 그래프?
// N명의 학생들의 키는 모두 다르다. 
// 내 키가 몇번째인지 알 수 있는 학생들이 모두 몇명인지 계싼해라. 
// 그래프를 돌때, set같은데에다가 넣어서 만약 갯수가 N-1 개면 확실히 아는것. 그걸 500번?


// 시간복잡도
// N은 500 q, 비교횟수는 M 
// 그래프를 만드는데. 반대로 가는 방향?
// 위에서 내려오는것.
// 연결은 다 되어있으려나? ㅇㅇ 되어있는듯.
// 그래프를 만약에 큰쪽 -> 작은쪽으로 다 이으면 
// 그러면 노드마다 큰 set, 작은 set 넣고 마지막에 합친걸 N-1 개인지 판단?

// 500 * 500 250000 밖에 안됨.
// 그러면 작은 노드를 만나면 큰 노드 인덱스에는 작은 set에 작은노드 넣고. 작은노드 인덱스에는 
// 큰 set에 넣고 이거를 500번 반복? 그냥 한번? 
// 반복해야할듯? 아 근데 그러면 터질거같은데 
// 메모리는 초과 안나는데 시간? 
// 정방향 그래프, 역방향 그래프를 만들어서
// 하나의 노드에서 타고 올라가게끔 하는게 제일 깔끔한 풀이일듯.

class boj_2458 {
    public static int[] visited;
    public static int N;
    public static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N+1];
        ArrayList<Integer>[] revList = new ArrayList[N+1];
        visited = new int[N+1];
        
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 큰거에서 작은거
            list[to].add(from);
            // 작은거에서 큰거
            revList[from].add(to);
        }

        int answer =0;
        
        for(int i=1;i<N+1;i++){
            init();
            int count = bfs(list, i);
            init();
            int revCount = bfs(revList, i);

            if(count+ revCount == N-1) answer++;
        }

        System.out.println(answer);

        

        
        
    }
    public static void init(){
        for(int i=0;i<N+1;i++){
            visited[i] = 0;
        }
    }

    public static int bfs(ArrayList<Integer>[] list, int index){

        int count =0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        visited[index] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int value : list[current]){

                if(visited[value] == 1) continue;
                visited[value] = 1;
                count++;
                queue.add(value);
            }
        }

        return count;
    }

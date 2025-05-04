import java.util.*;
import java.lang.*;
import java.io.*;


// 12:29
// 프로젝트 팀원 수에는 제한이 없다
// 모든 학생들이 동일한 팀의 팀원인 경우처럼 한 팀만 있을 수 있음.
// 모든 학생들은 함께하고 싶은 학생을 한명만 선택할 수 있음.
// 혼자 하고싶은 학생은 자기 자신을 선택가능.
// 사이클을 돌아야 한 팀이 될 수 있다.
// 자기 자신은 바로 팀 가능.
// 이때 아무곳에도 속하지 않은 학생들의 수를 출력해라.
// 테스트 케이스 T 가 주어지고 
// 학생의 수 N 이 주어진다. 
// 번호는 1~ N 까지 주어진다.

// list를 만들긴 해야겠네. visited 배열이랑 
// 동적 배열에 저장을 해 뒀다가 이건 지금 퍼져나가는 느낌이 아닌데 0~100,000까지
// BFS 를 돌리면서 물론 visited 로 처리가 되니까 100,000 일듯?
// 이러면 DFS 여도 되는거 아닌가.?
// 1 2 3 4


class boj_9466 {
    
    public static int N;
    public static int[] team;
    public static int[] visited;
    public static HashSet<Integer> set;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=  Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        while(T > 0){
            N =  Integer.parseInt(br.readLine());
            st  = new StringTokenizer(br.readLine());
            team = new int[N+1];
            visited = new int[N+1];
            set = new HashSet<>();
    
            for(int i=1;i<N+1;i++){
                team[i] = Integer.parseInt(st.nextToken());
            }
    
            for(int i=1;i<N+1;i++){
                if(visited[i] != 1){
                    bfs(i);
                    
                }
            }
            
    
            System.out.println(N - set.size());
            T--;
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> bfsSet = new HashSet<>();
        
        queue.add(start);
        bfsSet.add(start);
        stack.add(start);
        visited[start] = 1;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            int next = team[current];

            if(visited[next] == 1){
                if(bfsSet.contains(next)){
                    if(current == next){ // 자기 자신을 가르킨다면 그냥 자기자신만
                        set.add(current);
                    }
                    else{ // 자기 자신도 아니고 사이클이라면

                        int size = stack.size();
                        while(size >0){
                            int find = stack.pop();

                            set.add(find);
                            
                            if(find == next){
                                break;
                            }
                            size--;
                        }
                    }
                }
                continue;
            }

            queue.add(next);
            visited[next] = 1;
            bfsSet.add(next);
            stack.add(next);
        }
    }
}
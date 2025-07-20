import java.util.*;
import java.lang.*;
import java.io.*;


// 그래프의 정점의 집합을 둘로 분할. 
// 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할. 
// 서로 인접하지 않도록 분할할 수 있을 떄, 
// 서로 인접하지 않도록 분할할 수 있다.
// 테스트 케이스 개수 K 개
// 정점의 갯수 V 번호가 차레로 붙어있다. 
// 이분 그래프면 YES, 아니면 NO
// 인접하지 않도록 분할한다? 
// 순환하지 않으면 이분그래프? 
// 짝수개로 순환하면 이분그래프지만 홀수개로 순환하면 이분그래프가 아니다.
// 여기서는 하나 시작점으로 두고 근처를 1, 0 반복해서 그래프를 돈다. 
// 이때 이미 방문한점인데 같은 0 이면 이거는 이분그래프가 아니다. 

class boj_1707 {
    public static int N ;
    public static int E;
    public static int[] visited;
    public static int[] check;

    static class Node{
        int index;
        int check;
        public Node(int index, int check){
            this.index = index;
            this.check = check;
        }
    }

    public static ArrayList<Integer>[] list;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while(T-- > 0){
        
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 그래프 초기화 및 생성.
            list = new ArrayList[N+1];
            for(int i=1;i<N+1;i++){
                list[i] = new ArrayList<>();
            }

            visited = new int[N+1]; 
            check = new int[N+1]; 
            Arrays.fill(check, -1);
            
            // 그래프에 엣지들 넣기
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                list[to].add(from);
                list[from].add(to);
            }

            boolean check = true;
            
            for(int i=1;i<N+1;i++){

                if(visited[i] == 1) continue;
                
                if(!bfs(i)){
                    check = false;
                    break;
                }
                
            }

            System.out.println(check ? "YES" : "NO");
        }
        
        
    }

    // check 1, 2 값으로처리. 
    
    public static boolean bfs(int start){

        boolean secondGraph = true;
        
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start,2));
        visited[start] = 1;
        check[start] = 2;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int next : list[node.index]){

                // 만약 방문한적이 있다면 그 방문한 지점의 check 값이랑 node.check 값이랑 같으면 NO
                if(visited[next] == 1){
                    if(check[next] == node.check){
                        secondGraph = false;
                    }
                    continue;
                }

                visited[next] = 1;
                
                int nextCheck = 0;
                if(node.check == 1){
                    nextCheck = 2;
                }
                else{
                    nextCheck = 1;
                }
                
                check[next] = nextCheck;
                
                queue.add(new Node(next, nextCheck));
                

                
            }
        }

        return secondGraph;
    }




































    
}
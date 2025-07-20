import java.util.*;
import java.lang.*;
import java.io.*;


// 그래프로 만들긴해야겠지?

// 어떻게 만들어야?

// 일단 맵으로 String 을 정수로 바꾸는게 좋을 것 같고. 
// 루트노드를 찾으면 되려나
// 그래프를 큰거에서 작은걸로만 원소를 넣어두면 리프노드를 찾을 순 있긴한데. 그러면 가장 작은 단위.
// 가장 낮은 단위를 찾고 그걸로 다 바꾸면 되긴하는데. 
// 배열을 이용해서 가장 작은 단위로 다 바꾸면 되긴할듯. 그리고 정렬 떄리던가 하고 .

class boj_10478 {

    static class Edge{
        int index;
        int weight;
        public Edge(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }

    static class Node{
        long ratio;
        String value;
        public Node(long ratio, String value){
            this.ratio = ratio;
            this.value = value;
        }
    }

    public static int N;
    public static int[] visited;
    public static long[] ratio;
    public static ArrayList<Edge>[] list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }
            
            st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<Integer, String> returnMap = new HashMap<>();

            for(int i=0;i<N;i++){
                String input = st.nextToken();
                map.put(input,i);
                returnMap.put(i, input);
            }

            // 그래프 생성
            list = new ArrayList[N];
            for(int i=0;i<N;i++){
                list[i] = new ArrayList<>();   
            }

            // 그래프 큰거에서 작은 방향으로 생성.
            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                String front = st.nextToken();
                String remain = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                String back = st.nextToken();

                // 양방향으로 저장, 더 작은쪽은 음수로 저장.
                list[map.get(front)].add(new Edge(map.get(back) , value));
                list[map.get(back)].add(new Edge(map.get(front) , -1 * value));
            }

            // bfs 를 이용해서 가장 큰 단위를 찾기.
            int findMaxIndex = -1;
            
            for(int i=0;i<N;i++){
                ratio = new long[N];
                visited = new int[N];

                bfs(i);

                boolean check = true;
                
                for(int j=0;j<N;j++){
                    if(ratio[j] == 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    findMaxIndex = i;
                    break;
                }
            }

            ArrayList<Node> last = new ArrayList<>();
            
            for(int i=0;i<N;i++){
                last.add(new Node(ratio[i], returnMap.get(i)));
            }

            last.sort((o1, o2) -> 
                Long.compare(o1.ratio, o2.ratio)
            );

            

            StringBuilder sb = new StringBuilder();

                
            for(int i=0;i<N;i++){
                sb.append(last.get(i).ratio);
                sb.append(last.get(i).value);
                if(i!=N-1){
                    sb.append(" = ");
                }
            }

            System.out.println(sb.toString());
            
        }

        
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = 1;
        ratio[start] = 1;

        while(!queue.isEmpty()){

            int current = queue.poll();

            for(Edge e : list[current]){
                if(visited[e.index] == 1) continue;

                if (e.weight > 0) {
                    ratio[e.index] = ratio[current] * e.weight;
                } else {
                    ratio[e.index] = ratio[current] / (-e.weight);
                }

                visited[e.index] = 1;
                queue.add(e.index);
            }
        }
    }


















    
}
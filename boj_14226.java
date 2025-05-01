import java.util.*;
import java.lang.*;
import java.io.*;


// 9: 27

// 스마일 이모티콘을 S개 보내려한다.

// 이미 화면에 이모티콘 1개를 입력했다.
// 3가지 연산만 사용해서 이모티콘을 S개만드려함.
// 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장.
// 클립보드에 있는 모든 이모티콘을 붙여넣기
// 화면에 있는 이모티콘중 하나를 삭제.

//모든 연산은 1초가 걸린다고 하고 
// 클립보드에 복사를 하면 이전에 있던 내용들이 덮어써지게됨 이걸 어떻게 처리?
// 비어있는 상태에서는 붙여넣기를 할 수 없음.  (조건처리 해줘야함)
// S는 1000개까지 가능. DFS 를 돌린다면 수없이 많아져서 안됨. 뺵트래킹인가 했는데
// 삭제를 하는 옵션이 있으니까 안될듯. 종료조건도 없고
// 그래서 BFS 라고 판단. 또 최소값을 찾는거니까 BFS겠네 판단.
// 클립보드라는 공간을 어떻게 처리할지가 관건 DFS 는 각자 가지고있으면 되는데 BFS는 
// 그러면 queue 에 넣는 값을 클래스를 만들어서 String으로 관리하면?
// 근데 S가 됐을때 바로 exit하면 되는거아닌가? 근데 계속 복사만하면? 조건처리?
// 이전에 했으면 못하는식으로? 그리고 화면 삭제? 음?
// BFS 로 하면 문제는 걸리는시간 while 두번써서. BFS가 맞네 

class boj_14226 {

    static class Node{
        int view;
        int clip;
        public Node(int view, int clip){
            this.view = view;
            this.clip = clip;
        }
    }

    public static int time=0;
    public static int N;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        
        bfs();

    }

    public static void bfs(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        visited[1][0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Node node = queue.poll();

                int view = node.view;
                int clip = node.clip;

                if(view == N){
                    System.out.println(time);
                    System.exit(0);
                }

                // 모두 복사해서 클립보드에 저장한다.
                if(view > 0 && !visited[view][view]){
                    int copy = view;
                    queue.add(new Node(view, copy));
                    visited[view][copy] = true;
                }
    
                
                // 클립보드에 있는 갯수만큼 추가한다. 
                // 비어있는 상태라면 붙여넣기가 안된다.
                if(clip > 0 && view + clip <= 2000 && !visited[view + clip][clip] ){
                    queue.add(new Node(view + clip, clip));
                    visited[view+clip][clip] = true;
                }

                // 삭제한다.
                if(view > 0 && !visited[view-1][clip]){
                    queue.add(new Node(view-1, clip));
                    visited[view-1][clip] = true;
                }

                
                size--;
            }
            time++;
        }
    }
}

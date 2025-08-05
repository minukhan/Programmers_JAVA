import java.util.*;
import java.lang.*;
import java.io.*;


class boj_2668 {
    public static int[] record;
    public static int[] arr;
    public static int count =0;
    public static ArrayList<Integer> list;
    public static int N;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i=1;i<N+1;i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }

        record = new int[N+1];
        list = new ArrayList<>();
        
        for(int i=1;i<N+1;i++){
            if(record[i] == 1) continue;
            bfs(i);
        }

        System.out.println(list.size());

        list.sort(Comparator.naturalOrder());
        
        for(int value : list){
            System.out.println(value);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N+1];
        HashSet<Integer> set = new HashSet<>();
        // visited 배열을 하나로 써도 되나?
        // 아니지. 초기값을 1로 두고 돌리자나. 따로 하나 만들어서 사용. 
        // 그러면 그 돌리는 과정을 set에 기록을 해놓으면서 돌린다. 
        // 그리고 만약에 start랑 같다? set을 record 에 기록한다. 
        // 그걸 N 번 반복하면 된다. 
        
        queue.add(start);
        visited[start] = 1;
        set.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();

            int next = arr[current];
            
            if(next == start){
                // set을 record 에 추가하는 함수.
                for(int value : set){
                    record[value] = 1;
                    list.add(value);
                }
                return;
            }

            if(visited[next] == 1) continue;
            queue.add(next); 
            visited[next] = 1;
            set.add(next);
        }
    }
}





















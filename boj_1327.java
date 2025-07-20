import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1327 {

    static class Node{
        String value;
        int count;
        public Node(String value, int count){
            this.value = value;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        String answer = "";
        String init = "";

        // 배열에 넣기, 시작값 구하기
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            init+= arr[i];
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 정답 추출하기.
        for(int i=0;i<N;i++){
            answer+= arr[i];
        }
        HashSet<String> set = new HashSet<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(init, 0));
        set.add(init);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            // 만약 같으면 count 출력
            if(node.value.equals(answer)){
                System.out.println(node.count);
                return;
            }
            
            for(int i=0;i<N-k+1;i++){

                // K 개 추출해서 뒤집는 코드 
                StringBuilder sb = new StringBuilder();
                sb.append(node.value.substring(i,i+k));
                sb.reverse();

                // 다음 값 찾는 코드 
                String next = node.value.substring(0,i) + sb.toString() + node.value.substring(i+k, N);

                
                // 중복체크를 set으로 처리 중복이 아니라면 큐에 추가 및 set에 추가
                if(!set.contains(next)){
                    queue.add(new Node(next, node.count + 1));
                    set.add(next);
                }
            }
        }

        System.out.println(-1);
        
    }
}

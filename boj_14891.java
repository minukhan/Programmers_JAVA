

import java.util.*;
import java.lang.*;
import java.io.*;

class boj_14891 {

    public static int[][] arr;
    public static int[][] nextArr;

    static class Node{
        int index;
        int direction;
        public Node(int index, int direction){
            this.index = index;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1부터 사용
        arr = new int[5][8];
        
        for(int i=1;i<5;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            
            simulation(index, direction);
        }

        int first = arr[1][0] == 0 ? 0 : 1; 
        int second = arr[2][0] == 0 ? 0 : 2; 
        int three = arr[3][0] == 0 ? 0 : 4; 
        int four = arr[4][0] == 0 ? 0 : 8;
        
        System.out.println(first + second + three + four);
        
    }

    public static void simulation(int index, int direction){

        nextArr = new int[5][8];

        for(int i=1;i<5;i++){
            for(int j=0;j<8;j++){
                nextArr[i][j] = arr[i][j];
            }
        }
        int[] visited = new int[5];

        Queue<Node> queue = new LinkedList<>();

        //회전을 해야함. 
        if(direction == 1){
            moveR(index);
        }
        else{
            moveL(index);
        }
        
        queue.add(new Node(index, direction));
        visited[index] = 1;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            int nextIndex =0;
            int nextDirection = node.direction == 1 ? -1 : 1;

            boolean check = true;
            // 왼쪽 보기
            nextIndex = node.index - 1;
    
            if(nextIndex < 1 || nextIndex > 4) check = false;
            if(check && visited[nextIndex] == 1) check = false;
            if(check && arr[nextIndex][2] == arr[node.index][6]) check = false;

            // true 일때만 진행하도록 수정. 
            if(check){
                if(nextDirection == 1){
                    moveR(nextIndex);
                }
                else{
                    
                    moveL(nextIndex);
                }
                queue.add(new Node(nextIndex, nextDirection));
                visited[nextIndex] = 1;
            }
            check = true;
            
            // 오른쪽 보기
            nextIndex = node.index + 1;
            if(nextIndex < 1 || nextIndex > 4) check = false;
            if(check && visited[nextIndex] == 1) check = false;
            if(check && arr[nextIndex][6] == arr[node.index][2]) check = false;
            
            // true 일때만 진행하도록 수정. 
            if(check){
                if(nextDirection == 1){
                    moveR(nextIndex);
                }
                else{
                    moveL(nextIndex);
                }
                queue.add(new Node(nextIndex, nextDirection));
                visited[nextIndex] = 1;
            }
        }
        arr = nextArr;
    }
    // 왼쪽으로 이동하는 로직. 
    // 왼쪽으로 왜이동? 
    
    public static void moveR(int index){
        int record = nextArr[index][7];
        for(int i=6;i>=0;i--){
            nextArr[index][(i+1)] = nextArr[index][i];
        }
        nextArr[index][0] = record;
    }
    
    public static void moveL(int index){
        int record = nextArr[index][0];
        for(int i=0;i<7;i++){
            nextArr[index][i] = nextArr[index][(i+1) % 8];
        }
        nextArr[index][7] = record;
    }
}









































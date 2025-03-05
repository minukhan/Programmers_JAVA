import java.util.*;

import java.lang.*;

import java.io.*;

class FindMaze {


    public static int[][] road;
    public static int[] dx ={ 0,0, -1,1};
    public static int[] dy ={ 1,-1, 0,0};
    public static boolean[][] visited;
    public static int[][] count;
    public static int M;
    public static int N;
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x= x;
            this.y= y;
        } 

    }

    

    public static void FindMaze(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        road = new int[N][M];

        count = new int[N][M];

        

        for(int i=0;i<N;i++){

            String row = br.readLine();

            for(int j=0;j<M;j++){
                road[i][j] = row.charAt(j) - '0';

            }

        }

        bfs();
        System.out.println(count[N-1][M-1]);

    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));

        visited[0][0] = true;

        count[0][0] = 1;

        

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<dx.length;i++){

                int nx = dx[i] + node.x;

                int ny = dy[i] + node.y;

                if(nx<0 || nx>=M || ny < 0 || ny>=N) continue;

                if(visited[ny][nx]) continue;

                if(road[ny][nx] != 1) continue;

                queue.add(new Node(nx,ny));

                visited[ny][nx] = true;

                count[ny][nx] = count[node.y][node.x] + 1;

            }

        }


    }

}
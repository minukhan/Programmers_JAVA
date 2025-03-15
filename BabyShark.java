import java.util.*;
import java.lang.*;
import java.io.*;

class BabyShark { //9:14

    public static int[][] fish;
    public static int N;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int currentSize;
    public static int currentCount;
    public static int time =0;
    public static int startX=-1;
    public static int startY=-1;

    static class Shark{
        int x;
        int y;
        public Shark(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void BabyShark(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        currentSize = 2;
        currentCount =0;
        
        // 입력 배열 선언 및 초기화
        fish = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                fish[i][j] = Integer.parseInt(st.nextToken());

                if(fish[i][j] == 9){
                    startY = i;                    
                    startX = j;
                    fish[i][j] = 0;
                }
            }
        }

        
        // 물고기 M, 아기상어 1
        // 아기상어 크기 2 1초에 상하좌우로 한칸씩 이동.

        // 먼저 현재 위치에서 이동할 수 있으며 최단거리로 갈 수 있는곳을 찾음.
        
        // 그걸 반복
        while(true){

            int prevTime = time;
            bfs();

            if(prevTime == time) break;
            
        }
        
        System.out.println(time);
    }

    public static void bfs(){

        Queue<Shark> queue = new LinkedList<>();

        int[][] dist = new int[N][N];

        for(int[] row : dist) Arrays.fill(row,-1);

        int min = Integer.MAX_VALUE;
        ArrayList<Shark> fishList = new ArrayList<>();
        
        queue.add(new Shark(startX,startY));
        dist[startY][startX] = 0;

        while(!queue.isEmpty()){

            Shark shark = queue.poll();
            
            int x = shark.x;
            int y = shark.y;
        
            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 인덱스 범위 밖으로 나갈경우 제외
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >=N) continue;

                // 이미 방문했으면 끝.
                if(dist[nextY][nextX] != -1) continue;
                
                // 크기가 작으면 못지나감.
                if(currentSize < fish[nextY][nextX]) continue;

                dist[nextY][nextX] = dist[y][x] + 1;
                queue.add(new Shark(nextX,nextY));
                
                if(fish[nextY][nextX] == 0) continue;

                if(fish[nextY][nextX] == currentSize) continue;

                if(fish[nextY][nextX] < currentSize){
                    
                    if(dist[nextY][nextX] < min){
                        fishList.clear();
                        min = dist[nextY][nextX];
                        fishList.add(new Shark(nextX,nextY));
                    }
                    else if(dist[nextY][nextX] == min){
                        fishList.add(new Shark(nextX,nextY));
                    }
                }
            }
        }

        // 만약 같은 거리의 물고기들이 여러개라면 정렬을 이용해서 선택.
        fishList.sort((a,b) -> {
            if(a.y != b.y) return a.y-b.y;
            return a.x-b.x;
        });

        if(fishList.isEmpty()) return;

        Shark findFish = fishList.get(0);

        fish[findFish.y][findFish.x] = 0;
        startX = findFish.x; 
        startY = findFish.y; 
        time += min;
            
        currentCount++;

        if(currentCount == currentSize){
            currentCount =0;
            currentSize++;
        }
    }
}
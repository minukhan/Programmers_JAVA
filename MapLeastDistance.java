import java.util.*;

class MapLeastDistance {
    
    public static int minCount=Integer.MAX_VALUE;
    
    public class Status{
        public int currentX;
        public int currentY;
        public int moveCount;
        
        public Status(int currentX, int currentY, int moveCount){
            this.currentX = currentX;
            this.currentY = currentY;
            this.moveCount = moveCount;
        }
    }
    
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {

        boolean[][] road = new boolean[maps.length][maps[0].length];
        
        for(int i=0;i<maps.length;i++){ // 0 이면 : true : 막혀있다는 뜻으로 정의.
            for(int j=0;j<maps[0].length;j++){
                if(maps[i][j] == 0){
                    road[i][j] = true;
                }
            }
        }
        
        Queue<Status> queue = new LinkedList<>();
        
        queue.add(new Status(0,0,1));
        
        while(!queue.isEmpty()){
            
            Status status = queue.poll();
            
            if(status.currentY == maps.length -1 && status.currentX == maps[0].length -1){
                return status.moveCount;
            }
            
            for(int i=0;i<dx.length;i++){
                int modifyX = status.currentX + dx[i];
                int modifyY = status.currentY + dy[i];

                if(modifyX < 0 || modifyY <0 || modifyY >= maps.length || modifyX >= maps[0].length){
                    continue;
                }

                if(road[modifyY][modifyX]){
                   continue; 
                }
                
                road[modifyY][modifyX] = true;
                queue.add(new Status(modifyX,modifyY, status.moveCount+1));
            }
            
        }
        
        return -1;
    }
    
    
}
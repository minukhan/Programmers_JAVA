class DungeonHP {
    
    static int maxCount=0; // 제일 큰 값 저장할 변수 
    
    public int DungeonHP(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length]; // 내가 돌았는지 안돌았는지 확인하는 boolean 변수 
        
        dfs(k, dungeons, visited, 0); // 재귀함수를 이용한 dfs
        
        return maxCount;
    }
    
    private void dfs(int k, int[][] dungeons, boolean[] visited, int count){
        
        maxCount = Math.max(maxCount, count);
        
        for(int i=0;i<dungeons.length; i++){
            int minrequire = dungeons[i][0];
            int damage = dungeons[i][1];
            
            if(minrequire <= k && !visited[i]){
                
                visited[i] = true;
                System.out.println("현재 순서: " + i + ", 남은 피로도: " + (k - dungeons[i][1]));
                dfs(k-damage, dungeons, visited, count+1);
                visited[i] = false;
            }
        }
    }
}
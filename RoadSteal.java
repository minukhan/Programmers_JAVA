class RoadSteal {
    int RoadSteal(int[][] land) {
        int answer = 0;
    
        for(int i=1;i<land.length;i++){
            
            land[i][0] = land[i][0] + Math.max(Math.max(land[i-1][1], land[i-1][2]) ,land[i-1][3]);
            land[i][1] = land[i][1] + Math.max(Math.max(land[i-1][0], land[i-1][2]) ,land[i-1][3]);
            land[i][2] = land[i][2] + Math.max(Math.max(land[i-1][1], land[i-1][0]) ,land[i-1][3]);
            land[i][3] = land[i][3] + Math.max(Math.max(land[i-1][1], land[i-1][2]) ,land[i-1][0]);
            
        }
        
        answer = Math.max(Math.max(Math.max(land[land.length-1][3],land[land.length-1][2]) ,land[land.length-1][1] ) ,land[land.length-1][0] );
        

        return answer;
    }
}
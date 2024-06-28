class parallel {
    public int parallel(int[][] dots) {
        int answer = 0;
        double incline=0.0;
        double incline2=1.0;
        
        for(int i=0;i<dots.length-1;i++){
            incline = (double)(dots[i][0] - dots[3][0]) / (dots[i][1] - dots[3][1]);
            incline2 = (double)(dots[(i+1)%3][0] - dots[(i+2)%3][0]) / (dots[(i+1)%3][1] - dots[(i+2)%3][1]);
            
            if(incline == incline2){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}
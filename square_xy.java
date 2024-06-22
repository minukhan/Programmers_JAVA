class square_xy {
    public int square_xy(int[][] dots) {
        int answer = 0;
        int x=0;
        int x2=0;
        int y2=0;
        int y=0;
        
        for(int i=1;i<4;i++){ // x2 찾는 코드
            y=dots[0][1];
            x=dots[0][0];
            if(y==dots[i][1]){
                x2=dots[i][0];
            }
            
            if(x==dots[i][0]){
                y2=dots[i][1];
            }
        }
        int temp=0;

        answer = Math.abs(x2-x) * Math.abs(y2 - y);

        return answer;
    }
}
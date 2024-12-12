class Park_PCCE {
    public int Park_PCCE(int[] mats, String[][] park) {
        int answer = -1;
        boolean result = false;
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                
                if(park[i][j].equals("-1")){
                    
                    for(int k=0;k<mats.length;k++){
                        
                        if(Square(park, mats[k], i,j) && mats[k] >= answer){
                            answer = mats[k];
                        }
                    }
                }
                
            }    
        }
        
        return answer;
    }
    
    private boolean Square(String[][] park, int n, int y, int x){
        
        boolean clean = true;
        
        for(int i=y;i<n+y;i++){
            for(int j=x;j<n+x;j++){
                
                if(i>=park.length || j>=park[0].length){
                    clean = false;
                    break;
                }
                else if(!park[i][j].equals("-1")){
                    clean = false;
                    break;
                }
            }
        }
        return clean;
    }
}
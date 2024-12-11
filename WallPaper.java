class WallPaper {
    public int[] WallPaper(String[] wallpaper) {
        
        int StartX = 51;
        int StartY = 51;
        int endX = -1;
        int endY = -1;
        
        int[] answer = new int[4];
        char[] fileArray = new char[wallpaper[0].length()];
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[0].length();j++){
                fileArray = wallpaper[i].toCharArray();
                
                if(fileArray[j]=='#'){
                    if(StartX>j) StartX = j;
                    if(StartY>i) StartY = i;
                    if(endX<j) endX = j;
                    if(endY<i) endY = i;
                }
            }
        }
        
        answer[0] = StartY;
        answer[1] = StartX;
        answer[2] = endY+1;
        answer[3] = endX+1;
        
        return answer;
    }
    
    
}
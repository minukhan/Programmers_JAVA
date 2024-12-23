import java.util.*;

class VisitiedLength {
    public int VisitiedLength(String dirs) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        
        int currentX = 5;
        int currentY = 5;
        
        
        for(int i=0;i<dirs.length();i++){
            
            String currentPosition = "" + currentX + currentY;
            
            switch(dirs.charAt(i)){
                case 'U':
                    if(currentY-1 >= 0){
                        currentY--;
                    }
                    break;
                case 'D':
                    if(currentY+1 <= 10){
                        currentY++;
                    }
                    break;
                case 'R':
                    if(currentX+1 <= 10){
                        currentX++;
                    }
                    break;
                case 'L':
                    if(currentX-1 >= 0){
                        currentX--;
                    }
                    break;
            }
            
            
            String nextPosition = "" + currentX + currentY;
            if(nextPosition.equals(currentPosition)){
                continue;
            }
            
            String move = "" + currentPosition + nextPosition;
            set.add(move);
            
            move = "" + nextPosition + currentPosition;
            set.add(move);
                
        }
        
        return set.size()/2;
    }
}
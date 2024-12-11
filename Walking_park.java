class Walking_park {
    public int[] Walking_park(String[] park, String[] routes) {
        int[] answer = {0,0};
        
        char[][] parkArr = new char[park.length][park[0].length()];
            
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                parkArr[i][j] = park[i].charAt(j);
                if(parkArr[i][j]=='S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        int count;
        
        for(int i=0;i<routes.length;i++){
            boolean DontMove = false;
            String[] routeArray = routes[i].split(" ");    
            int plus = Integer.parseInt(routeArray[1]);
            switch(routeArray[0]){
                case "N":
                    
                    if((answer[0] - plus)<0 || (answer[0]- plus)>=park.length){
                        DontMove = true;
                    }
                    if(answer[1]<0 || answer[1]>=park[0].length()){
                        DontMove = true;
                    }
                    
                    count = plus;
                    
                    while(count!=0 && !DontMove){
                        
                        if(parkArr[answer[0] - count][answer[1]]=='X'){
                            DontMove = true;
                        }
                        else{
                            count--;
                        }
                    }
                    
                    if(!DontMove){
                        answer[0] = answer[0] - plus;
                    }
                    break;
                case "S":
                    if((answer[0]+plus)<0 || (answer[0]+plus)>=park.length){
                        DontMove = true;
                    }
                    if(answer[1]<0 || answer[1]>=park[0].length()){
                        DontMove = true;
                    }
                    
                    count = plus;
                    
                    while(count!=0 && !DontMove){
                        
                        if(parkArr[answer[0] + count][answer[1]]=='X'){
                            DontMove = true;
                        }
                        else{
                            count--;
                        }
                    }
                    
                    if(!DontMove){
                        answer[0] = answer[0] + plus;
                    }
                    break;
                case "W":
                    if(answer[0]<0 || answer[0]>=park.length){
                        DontMove = true;;
                    }
                    if((answer[1]-plus)<0 || (answer[1]-plus)>=park[0].length()){
                        DontMove = true;;
                    }
                    
                    count = plus;
                    
                    while(count!=0 && !DontMove){
                        
                        if(parkArr[answer[0]][answer[1]-count]=='X'){
                            DontMove = true;
                        }
                        else{
                            count--;
                        }
                    }
                    
                    if(!DontMove){
                        answer[1] = answer[1] - plus;
                    }
                    break;
                case "E":
                    if(answer[0]<0 || answer[0]>=park.length){
                        DontMove = true;;
                    }
                    if((answer[1]+plus)<0 || (answer[1]+plus)>=park[0].length()){
                        DontMove = true;;
                    }
                    count = plus;
                    
                    while(count!=0 && !DontMove){
                        
                        if(parkArr[answer[0]][answer[1]+count]=='X'){
                            DontMove = true;
                        }
                        else{
                            count--;
                        }
                    }
                    if(!DontMove){
                        answer[1] = answer[1] + plus;
                    }
                    break;
            }
        }
                    
        
        return answer;
    }
}
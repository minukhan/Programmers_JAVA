class VideoPlayer {
    public String VideoPlayer(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] totalVideo = video_len.split(":");
        int totalM = Integer.parseInt(totalVideo[0]);
        int totals = Integer.parseInt(totalVideo[1]);
        
        String[] posVideo = pos.split(":");
        int posM = Integer.parseInt(posVideo[0]);
        int poss = Integer.parseInt(posVideo[1]);
        
        String[] opStart = op_start.split(":");
        int opstartM = Integer.parseInt(opStart[0]);
        int opstarts = Integer.parseInt(opStart[1]);
        
        String[] opEnd = op_end.split(":");
        int opEndM = Integer.parseInt(opEnd[0]);
        int opEndS = Integer.parseInt(opEnd[1]);
        
        //초반에 오프닝 시간인지 확인
        if(Compare(posM,poss,opstartM,opstarts)==1 && Compare(opEndM,opEndS,posM,poss)==1){
                    
                    posM = opEndM;
                    poss = opEndS;
                    
        }
        
        for(int i=0;i<commands.length;i++){
            
            if(commands[i].equals("next")){
                poss+=10;
                if(poss>=60){
                    poss -= 60;
                    posM++;
                }
                if(Compare(posM,poss,totalM,totals)==1){
                    
                    posM = totalM;
                    poss = totals;
                }
                
                //증가하고 시간인지 확인
                if(Compare(posM,poss,opstartM,opstarts)==1 && Compare(opEndM,opEndS,posM,poss)==1){
                    
                    posM = opEndM;
                    poss = opEndS;
                }
                                
            }
            else{
                poss-=10;
                if(poss<0){
                    poss += 60;
                    posM--;
                }
                if(posM<0){
                    posM = 0;
                    poss = 0;
                }
                
                //감소하고 시간인지 확인
            
                if(Compare(posM,poss,opstartM,opstarts)==1 && Compare(opEndM,opEndS,posM,poss)==1){
                    
                    posM = opEndM;
                    poss = opEndS;
                    
                }
            }
            
        }
        
        String resultM;
        String resultS;
        
        if(posM<10){
            resultM = "0" + posM;
        }
        else{
            resultM = "" + posM;
        }
        
        if(poss<10){
            resultS = "0" + poss;
        }
        else{
            resultS = "" + poss;
        }
        
        
        
        answer = resultM + ":" + resultS;
        
        return answer;
    }
    
    private int Compare(int firstM, int firstS,int SecondM, int SecondS ){
        int answer = 0;
        
        if(firstM>SecondM){
            answer = 1;
        }
        else if(firstM==SecondM){
            if(firstS>=SecondS){
                answer = 1;
            }
            else{
                answer = 2;
            }
        }
        else{
            answer = 2;
        }
        
        
        return answer;
    }
}

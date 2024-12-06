class Personality_test {
    public String Personality_test(String[] survey, int[] choices) {
        String answer = "";
        int[] Score = new int[4];
        
        
        for(int i=0;i<survey.length;i++){
            char firstChar = survey[i].charAt(0);
            switch(firstChar){
                case 'R': case'T':
                    if(firstChar=='R'){
                        Score[0] += choices[i] - 4;
                    }
                    else{
                        Score[0] -= choices[i] - 4;
                    }
                    break;
                case 'C': case'F':
                    if(firstChar=='C'){
                        Score[1] += choices[i] - 4;
                    }
                    else{
                        Score[1] -= choices[i] - 4;
                    }
                    break;
                case 'J': case'M':
                    if(firstChar=='J'){
                        Score[2] += choices[i] - 4;
                    }
                    else{
                        Score[2] -= choices[i] - 4;
                    }
                    break;
                case 'A': case'N':
                    if(firstChar=='A'){
                        Score[3] += choices[i] - 4;
                    }
                    else{
                        Score[3] -= choices[i] - 4;
                    }
                    break;
            }
            
        }
            for(int i=0;i<Score.length;i++){
                switch(i){
                    case 0:
                        if(Score[i]<=0){
                            answer+= "R";
                        }
                        else{
                            answer+= "T";
                        }
                        break;
                    case 1:
                        if(Score[i]<=0){
                            answer+= "C";
                        }
                        else{
                            answer+= "F";
                        }
                        break;
                    case 2:
                        if(Score[i]<=0){
                            answer+= "J";
                        }
                        else{
                            answer+= "M";
                        }
                        break;
                    case 3:
                        if(Score[i]<=0){
                            answer+= "A";
                        }
                        else{
                            answer+= "N";
                        }
                        break;
                }
                
            }
        
        return answer;
    }
}
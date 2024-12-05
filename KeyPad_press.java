class KeyPad_press {
    public String KeyPad_press(int[] numbers, String hand) {
        String answer = "";
        
        int rigthhand = 12;
        int lefthand = 10;
            
        
        for(int i=0;i<numbers.length;i++){
            
            switch(numbers[i]){
                case 1: case 4: case 7:
                    lefthand = numbers[i];
                    answer += "L";
                    break;
                case 3: case 6: case 9:
                    rigthhand = numbers[i];
                    answer += "R";
                    break;
                case 2: case 5: case 8: case 0:
                    
                    if(numbers[i]==0){ 
                        numbers[i] = 11;
                    }
                    int rightDistance = Math.abs((rigthhand-1)/3-(numbers[i]-1)/3)
                                     + Math.abs((rigthhand-1)%3-(numbers[i]-1)%3);
                    int leftDistance = Math.abs((lefthand-1)/3-(numbers[i]-1)/3)
                                     + Math.abs((lefthand-1)%3-(numbers[i]-1) %3);
                    
                    if(leftDistance < rightDistance){
                        lefthand = numbers[i];
                        answer+="L";
                    }
                    else if(leftDistance>rightDistance){
                        rigthhand = numbers[i];
                        answer+="R";
                    }
                    else{
                        if(hand.equals("left")){
                            lefthand = numbers[i];
                            answer+="L";
                        }
                        else{
                            rigthhand = numbers[i];
                            answer+="R";
                        }
                    }
                    break;
                
            }
        }
        
        
        return answer;
    }
}
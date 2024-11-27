class Easy_keyboard {
    public int[] Easy_keyboard(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int min = 1000;
        int count =0;
        
        for(int i=0;i<targets.length;i++){
            
            char[] targetArray = targets[i].toCharArray();
            
            for(int j=0;j<targetArray.length;j++){
                
                for(int k=0;k<keymap.length;k++){
                    
                    count = keymap[k].indexOf(targetArray[j]);
                    
                    if( count == -1){
                        continue;
                    }
                    else if(min > count){
                         min = count;
                    }
                }
                if(min==1000){
                    answer[i] = -1;
                    break;
                }
                else{
                    answer[i] += min+1;
                    min = 1000;
                }
            }
            
        }
        return answer;    
        
    }
}
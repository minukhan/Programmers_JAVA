class character_spot {
    public int[] character_spot(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int left =0;
        int right=0;
        int up =0;
        int down=0;
        
        int xlen = board[0] / 2;
        int ylen = board[1] / 2;
        
        for(int i=0;i<keyinput.length;i++){
            if(keyinput[i].equals("left")){
                if(left!=xlen){
                    if(right>0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
            else if(keyinput[i].equals("right")){
                if(right!=xlen){
                    if(left>0){
                        left--;
                    }
                    else{
                        right++;
                    }
                }
            }
            else if(keyinput[i].equals("up")){
                if(up!=ylen){
                    if(down>0){
                        down--;
                    }
                    else{
                        up++;
                    }
                }
            }
            else if(keyinput[i].equals("down")){
                if(down!=ylen){
                    if(up>0){
                        up--;
                    }
                    else{
                        down++;
                    }
                }
            }
        }
        
        answer[0] = right-left;
        answer[1] = up-down;
        
        
        return answer;
    }
}
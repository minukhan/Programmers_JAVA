class Kakao_FrindsBlock4 {
    public int Kakao_FrindsBlock4(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] kakao = new char[m][n];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                kakao[i][j] = board[i].charAt(j);
            }
        }
        
        int result = 0;
        
        while(true){
            result = blockdelete(kakao);
            if(result == 0){
                break;
            }
            
            answer += result;
            
        }
        
        return answer;
    }
    
    private int blockdelete(char[][] block){
        
        char current;
        int count =0;
        boolean[][] deleteArr = new boolean[block.length][block[0].length];
        
        // 삭제한 블럭 표시
        for(int i=0;i<block.length-1;i++){
            for(int j=0;j<block[i].length-1;j++){
                
                current = block[i][j];
                
                if('0'!=block[i+1][j] && '0'!=block[i][j+1] && '0'!=block[i+1][j+1] && '0'!=current){
                    
                    if(current==block[i+1][j] && current==block[i][j+1] && current==block[i+1][j+1]){
                        deleteArr[i][j] = true;
                        deleteArr[i+1][j] = true;
                        deleteArr[i][j+1] = true;
                        deleteArr[i+1][j+1] = true;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        // 삭제한 블럭의 갯수 세기
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                if(deleteArr[i][j]){
                    count++;
                }
            }
        }
        // 블럭 내리기 
        for(int i=0;i<block[0].length;i++){
            int index=block.length-1;
            
            for(int j=block.length-1;j>=0;j--){
                
                if(!deleteArr[j][i]){
                    block[index][i] = block[j][i];
                    index--;
                }
                else{
                    continue;                                        
                }
            }
            
            while(index>=0){
                block[index][i] = '0';
                index--;
            }
        }
        
        
        return count;
        
    }
    
}
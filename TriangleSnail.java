class TriangleSnail {
    public int[] TriangleSnail(int n) {
        
        int[][] piramid = new int[n][n];
        int number =1;
        int status =1;

        int i=0;
        int j=0;
        piramid[i][j] = number++;
        
        while(true){
            
            switch(status){
                case 1:
                    if(i+1>=n || piramid[i+1][j] != 0){
                        status = 2;
                    }
                    else{
                        i++;
                        piramid[i][j] = number++;
                    }
                    break;
                case 2:
                    if(j+1>=n || piramid[i][j+1] != 0){
                        status = 3;
                    }
                    else{
                        j++;
                        piramid[i][j] = number++;
                    }
                    break;          
                case 3:
                    if(i-1<0 || j-1<0 || piramid[i-1][j-1] !=0){
                        status = 1;
                    }
                    else{
                        i--;
                        j--;
                        piramid[i][j] = number++;
                        
                    }
                    break;
            }
            
            // 다음 이동이 불가능하면 종료
            if ((i + 1 >= n || piramid[i + 1][j] != 0) &&
                (j + 1 >= n || piramid[i][j + 1] != 0) &&
                (i - 1 < 0 || j - 1 < 0 || piramid[i - 1][j - 1] != 0)) {
                break;
            }
        }
        
        // 결과를 1차원 배열로 변환
        int[] result = new int[n * (n + 1) / 2];
        int index = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= r; c++) {  // 삼각형 모양만 추출
                result[index++] = piramid[r][c];
            }
        }
        
        return result;
    }
}

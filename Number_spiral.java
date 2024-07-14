class Number_spiral {
    public int[][] Number_spiral(int n) {
        int[][] arr = new int[n+2][n+2];
        int[][] answer = new int[n][n];
        boolean up = false;
        int count =1;
        
        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                if(i==0 ||i==n+1 || j==0 || j==n+1){
                    arr[i][j] = -1;
                }
            }
        }
        
        int i=1;
        int j=1;
        
        while(count<n*n+1){
            if(count==n*n){
                arr[i][j] = count;
                break;
            }
            if(up){
                if(arr[i-1][j]!=0){
                    up = false;
                }
                else{
                    arr[i][j] = count;
                    count++;
                    i--;
                }
            }
            else{
                if(arr[i][j+1]==0){
                    arr[i][j] = count;
                    count++;
                    j++;
                }
                else if(arr[i+1][j]==0){
                    arr[i][j] = count;
                    count++;
                    i++;
                }
                else if(arr[i][j-1]==0){
                    arr[i][j] = count;
                    count++;
                    j--;
                }
                else if(arr[i-1][j]==0){
                    arr[i][j] = count;
                    count++;
                    i--;
                    up = true;
                }
                else{
                    count++;
                }
            }
        }
        
        
        for(int a=1;a<n+1;a++){
            for(int b=1;b<n+1;b++){
                answer[a-1][b-1] = arr[a][b]; 
            }
        }
            

        return answer;
    }
}


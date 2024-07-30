class Secret_map {
    public String[] Secret_map(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] square = new int[n][n];
        int[][] square2 = new int[n][n];
        
        for(int i=0;i<answer.length;i++){//answer 초기화 코드
            answer[i] = "";
        }
        
        int count=n-1;
        
        for(int i=0;i<arr1.length;i++){ //arr1 2진수로 변환
            count=n-1;
            while(count>=0){
                square[i][count] = arr1[i]%2;
                arr1[i] = arr1[i]/2;
                count--;
            }
        }
        
        for(int i=0;i<arr2.length;i++){ //arr2 2진수로 변환
            count=n-1;
            while(count>=0){
                square2[i][count] = arr2[i]%2;
                arr2[i] = arr2[i]/2;
                count--;
            }
        }
        
        for(int i=0;i<square.length;i++){ //arr1, arr2 변환한거 비교후 asnwer에 추가
            for(int j=0;j<square.length;j++){
                if(square2[i][j]==0 && square[i][j]==0){
                    answer[i]+=" ";
                }
                else{
                    answer[i]+="#";
                }
            }
        }
        
        return answer;
    }
}
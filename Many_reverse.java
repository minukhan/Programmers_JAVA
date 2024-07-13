class Many_reverse {
    public String Many_reverse(String my_string, int[][] queries) {
        String answer = "";
        String reverse = "";
        
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<my_string.length();j++){
                
                if(queries[i][0]<=j && queries[i][1]>=j){
                    
                    for(int k = queries[i][1];k>=queries[i][0];k--){
                        reverse += my_string.charAt(k);
                    }
                    j= queries[i][1];
                }
                else{
                    reverse += my_string.charAt(j);
                }
                
            }
            
            my_string = reverse;
            reverse = "";
        }
        answer = my_string;
        
        return answer;
    }
}
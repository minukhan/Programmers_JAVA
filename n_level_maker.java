class n_level_maker {
    public int[][] n_level_maker(int[] num_list, int n) {
        
        int sep = num_list.length/n;
        int[][] answer = new int[sep][n];
        int count =0;
        
        for(int i=0;i<sep;i++){
            for(int j=0;j<n;j++){
                answer[i][j] = num_list[count];
                count++;
            }
        }
        
        return answer;
    }
}
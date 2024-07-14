class Ranking_one_Two_three {
    public int Ranking_one_Two_three(int[] rank, boolean[] attendance) {
        int answer = 0;
        int min =101;
        int minindex=-1;
        
        for(int j=0;j<3;j++){
            for(int i=0;i<rank.length;i++){
                if(min>rank[i] && attendance[i]){
                    min = rank[i];
                    minindex=i;
                }
            }
            
            rank[minindex] = 101;
            min = 101;
            
            if(j==0){
                answer += 10000*minindex;
            }
            else if(j==1){
                answer += 100*minindex;
            }
            else{
                answer+= minindex;
            }
            
        }
        
        return answer;
    }
}
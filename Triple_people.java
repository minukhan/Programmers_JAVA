class Triple_people {
    public int Triple_people(int[] number) {
        int answer = 0;
        
        for(int i=0;i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                for(int k=j+1;k<number.length;k++){
                    if(number[k]+number[j]+number[i]==0){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
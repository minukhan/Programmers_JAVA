class Card_space {
    public String Card_space(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int index1=0;
        int index2=0;
        boolean boo1 = true; 
        boolean boo2 = true; 
        
        for(int i=0;i<goal.length;i++){
            if(boo1 && cards1[index1].equals(goal[i])){
                 index1++;
                if(index1==cards1.length){
                    boo1 = false;
                }
            }
            else if(boo2 && cards2[index2].equals(goal[i])){
                index2++;
                if(index2==cards2.length){
                    boo2 = false;
                }
            }
            else{
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
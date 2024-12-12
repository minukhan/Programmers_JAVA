import java.util.HashMap;

class Gift_MostCountPerson {
    public int Gift_MostCountPerson(String[] friends, String[] gifts) {
        int answer = 0;
        int GivePerson;
        int GivedPerson;
        
        int[][] giftRecord = new int[friends.length][friends.length];
        
        
        //해시값으로 index로 접근
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
        }
        
        
        //배열에 맞춰서 선물의 주고 받음을 기록
        for(int i=0;i<gifts.length;i++){
            String[] giveGiven = gifts[i].split(" ");
            
            GivePerson = map.get(giveGiven[0]);
            GivedPerson = map.get(giveGiven[1]);
            
            giftRecord[GivePerson][GivedPerson]++;
        }
        
        //배열을 이용해서 점수를 계산
        int[] GiftScore = new int[friends.length];
        int[] GiftGivenScore = new int[friends.length];
        int[] totalScore = new int[friends.length];
        
        for(int j=0;j<giftRecord.length;j++){
                for(int k=0;k<giftRecord[0].length;k++){
                    GiftScore[j] += giftRecord[j][k];
                    GiftGivenScore[k] += giftRecord[j][k];
                }
        }
        
        //최종점수 계산 
        for(int i=0;i<GiftScore.length;i++){
            totalScore[i] = GiftScore[i] - GiftGivenScore[i];   
        }
        
        //선물이 있다면 그거에 맞는 계산
        int[] answerArray = new int[giftRecord.length];
        
        for(int j=0;j<giftRecord.length;j++){
                for(int k=0;k<=j;k++){
                    if(giftRecord[j][k]!=0 || giftRecord[k][j]!=0){
                        if(giftRecord[j][k] > giftRecord[k][j]){
                            answerArray[j]++;
                        }
                        else if(giftRecord[j][k] == giftRecord[k][j]){
                            if(totalScore[j] > totalScore[k]){
                                answerArray[j]++;
                            }
                            else if(totalScore[j] < totalScore[k]){
                                answerArray[k]++;
                            }
                        }
                        else{
                            answerArray[k]++;
                        }
                    }
                    else{
                        if(totalScore[j] > totalScore[k]){
                            answerArray[j]++;
                        } 
                        else if(totalScore[j] < totalScore[k]){
                            answerArray[k]++;
                        }
                    }
                }
        }
        
        
        //정답중 가장 큰 값을찾는 계산 
        for(int i=0;i<answerArray.length;i++){
            answer = Math.max(answer,answerArray[i]);
        }
        
        
        
        
        return answer;
    }
}
import java.util.ArrayList;

//동적 배열로 저장, contains 로 찾아내고 있다면 
//index 찾아서 
// 그 값 없애기

class PlayerNotFinish {
    public String PlayerNotFinish(String[] participant, String[] completion) {
        String answer = "";
        
        ArrayList<String> participantList = new ArrayList<>();
        ArrayList<String> completionList = new ArrayList<>();
        
        for(int i=0;i<participant.length;i++){
            participantList.add(participant[i]);
        }
        for(int i=0;i<completion.length;i++){
            completionList.add(completion[i]);
        }
        participantList.sort(String::compareTo);
        completionList.sort(String::compareTo);
        
        
        
        for(int i=0;i<completionList.size();i++){
            
            if(!participantList.get(i).equals(completionList.get(i))){
                answer = participantList.get(i);
                break;
            }
        }
        
        if(answer.equals("")){
            answer = participantList.get(participantList.size()-1);
        }
        
//         int index=0;
        
//         ArrayList<String> list = new ArrayList<>();
        
//         for(int i=0;i<completion.length;i++){
//             list.add(completion[i]);
//         }
        
//         for(int i=0;i<participant.length;i++){
//             if(list.contains(participant[i])){
//                 index = list.indexOf(participant[i]);
//                 list.remove(index);
//             }
//             else{
//                 answer = participant[i];
//             }
//         }
        
        return answer;
    }
}
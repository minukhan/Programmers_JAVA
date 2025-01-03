import java.util.*;

class KakaoOpenChating {
    public String[] KakaoOpenChating(String[] record) {
        String check;
        String userId;
        String userName;
        
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<record.length;i++){
            String[] arr = record[i].split(" ");
                        
            check = arr[0];
            
            if(check.equals("Enter")){
                userId = arr[1];
                userName = arr[2];
                map.put(userId,userName);
                list.add(userId + " E");
            }
            else if(check.equals("Change")){
                userId = arr[1];
                userName = arr[2];
                map.put(userId,userName);
            }
            else if(check.equals("Leave")){
                userId = arr[1];
                
                list.add(userId + " L");
            }
        }
        
        String[] answer = new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            
            String[] arrr = list.get(i).split(" ");
            
            if(arrr[1].equals("E")){
                answer[i] = map.get(arrr[0]) + "님이 들어왔습니다.";
            }
            else{
                answer[i] = map.get(arrr[0]) + "님이 나갔습니다.";
            }
            
        }
        
        
        return answer;
    } 
}
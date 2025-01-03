import java.util.*;

class ParkingFee {
    public int[] ParkingFee(int[] fees, String[] records) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int hour=0;
        int minute =0;
        int number =0;
        String INOUT="";
        String time ="";
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<Integer,Integer> numbermap = new HashMap<>();
        
        // 입차 출차 코드
        for(int i=0;i<records.length;i++){
            time = records[i].substring(0,5);
            number = Integer.parseInt(records[i].substring(6,10));
            INOUT = records[i].substring(11,records[i].length());
            String inTime="";
            
            if(INOUT.equals("IN")){
                
                map.put(number,time);
            }
            else if(INOUT.equals("OUT")){
                
                inTime = map.get(number);
                
                int ParkingTime = ( Integer.parseInt(time.substring(0,2)) - Integer.parseInt(inTime.substring(0,2))) * 60 + Integer.parseInt(time.substring(3,5)) - Integer.parseInt(inTime.substring(3,5));
                
                
                if(numbermap.containsKey(number)){
                    numbermap.put(number, numbermap.get(number) + ParkingTime);
                }
                else{
                    numbermap.put(number,ParkingTime);
                }
                map.remove(number);
            }
        }
        
        // 만약 출차가 없을 경우 추차시간 계산
        if(!map.isEmpty()){
            for(Integer value : map.keySet()){
                int emnum = value;
                String emtime = map.get(emnum);
                
                int ParkingTime = ( 23 - Integer.parseInt(emtime.substring(0,2))) * 60 + 59 - Integer.parseInt(emtime.substring(3,5));
                
                if(numbermap.containsKey(emnum)){
                    numbermap.put(emnum, numbermap.get(emnum) + ParkingTime);
                }
                else{
                    numbermap.put(emnum,ParkingTime);
                }
            }
        }
        
        //요금 계산 배열 생성
        int[] arr = new int[numbermap.size()];
        int count =0;
        
        
        for(int value : numbermap.keySet()){
            
            arr[count] = value;
            count++;
            
        }
        
        Arrays.sort(arr);
        
        // 요금계산 코드
        for(int i=0;i<arr.length;i++){
            
            
            int lastTime = numbermap.get(arr[i]);
            
            System.out.println("lastTime : " + lastTime);
            System.out.println("fees[1] : " + fees[1]);
            
            if(lastTime > fees[0]){
                if((lastTime - fees[0]) % fees[2]==0){
                    
                    list.add(fees[1] + ((lastTime - fees[0]) / fees[2]) * fees[3]);
                }
                else{
                    list.add(fees[1] + ((lastTime - fees[0]) / fees[2]   + 1) * fees[3]);
                }
            }
            else{
                list.add(fees[1]);
            }
        }
        
        //정답 배열로 변환
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}
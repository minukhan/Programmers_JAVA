import java.util.HashMap;
import java.util.ArrayList;

class Personal_infomation {
    public int[] Personal_infomation(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> hash = new HashMap<>();

        String alpa;
        int plus;
        
        //terms 배열 HashMap 에 가공해서 저장
        for(int i=0;i<terms.length;i++){
            String[] termsArray = terms[i].split(" ");
            alpa = termsArray[0];
            plus = Integer.parseInt(termsArray[1]);
            
            hash.put(alpa,plus);
            System.out.println(" plus : " +plus);
            System.out.println(" alpa : " +hash.get(alpa));
            
        }
        
        
        String priAlpa;
        int Year = 0;
        int Month = 0;
        int Day = 0;
        String count = "";
        
        //유효기간 split하여 변수저장
        String[] todayArray = today.split("\\.");
        
        int tYear = Integer.parseInt(todayArray[0]);
        int tMonth = Integer.parseInt(todayArray[1]);
        int tDay = Integer.parseInt(todayArray[2]);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<privacies.length;i++){
            
            String[] termsArray = privacies[i].split(" ");
            String[] dateArray = termsArray[0].split("\\."); // . 은 escape 문자로 인식되므로 앞에 \\ 를 붙여줘야한다.
        
            priAlpa = termsArray[1];
            
            // 문자열을 split 하여 처리
            
            Year = Integer.parseInt(dateArray[0]);
            Month = Integer.parseInt(dateArray[1]);
            Day = Integer.parseInt(dateArray[2]);
            
            Month = Month + hash.get(priAlpa);

            while(Month>12){
                Month = Month - 12;
                Year++;
            }
            
            // 유효기간 아래인지 판단
            if(Year < tYear){
                list.add(i+1);

            }
            else if(Year == tYear){
                if(Month < tMonth){
                    list.add(i+1);
                }
                else if(Month == tMonth){
                    if(Day <= tDay){
                        list.add(i+1);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class News_Clustering {
    public int News_Clustering(String str1, String str2) {
        int answer = 0;
        
        String first = str1.toLowerCase();
        String second = str2.toLowerCase();
        
        ArrayList<String> setFirst = makeArrayList(first);
        ArrayList<String> setSecond = makeArrayList(second);
        
        int sameCount =0;
        int hapCount=0;
        
        for(int i=0;i<setFirst.size();i++){
            System.out.println("setFirst.get(i) : "+ setFirst.get(i));
        }
        for(int i=0;i<setSecond.size();i++){
            System.out.println("setSecond.get(i) : "+ setSecond.get(i));
        }
        
        for(int i=0;i<setFirst.size();i++){
            if(setSecond.contains(setFirst.get(i))){
                setSecond.remove(setFirst.get(i));
                sameCount++;
            }                         
        }
        
        hapCount = setSecond.size() + setFirst.size();
        
        
        
        if(hapCount == 0){
            answer = 65536;
        }
        else{
            answer = (int)((sameCount / (double)hapCount) * 65536);
        }
        
        return answer;
    }
    // 집합 반환
    private ArrayList<String> makeArrayList(String s){
        
        ArrayList<String> set = new ArrayList<>();
        
        for(int i=0;i<s.length()-1;i++){
            if( 97 <= s.charAt(i) && 122 >= s.charAt(i) &&  97 <= s.charAt(i+1) && 122 >= s.charAt(i+1)){
                String result = "";
                result = result + s.charAt(i) + s.charAt(i+1);
                set.add(result);
            }
            else{
                continue;
            }
        }
        
        return set;
    }
}
import java.util.*;

class KPrimeCount {
    public int KPrimeCount(int n, int k) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        String number =Integer.toString(n,k);
        
        String result ="";
        for(int i=0;i<number.length();i++){
            if(i == number.length()-1){
                result += number.charAt(i);
                list.add(result);
                break;
            }
            if(number.charAt(i)=='0'){
                if(result.equals("")){
                    continue;
                }
                list.add(result);
                
                result = "";
            }
            else{
                result += number.charAt(i);
            }
        }
        
        for(int i=0;i<list.size();i++){
            
            Long num = Long.parseLong(list.get(i));
            if(isPrime(num)){
                answer++;
            }
        }
        
        Long a = 49L;
        return answer;
    }
    
    private boolean isPrime(Long num){
        
        Long number = num;
        
        boolean ispri = true;
        if(number<2){
            ispri = false;
            return ispri;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                ispri = false;
            }
        }
        return ispri;
    }
}
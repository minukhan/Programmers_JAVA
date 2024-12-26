import java.util.*;

class StockPrice {
    public int[] StockPrice(int[] prices) {
        int currentPrice = 0;
        int count =0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<prices.length;i++){
            currentPrice = prices[i];
            count =0;
            for(int j=i;j<prices.length;j++){
                if(currentPrice>prices[j]){
                    break;
                }
                if(j == prices.length-1){
                    break;
                }
                count++;
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}
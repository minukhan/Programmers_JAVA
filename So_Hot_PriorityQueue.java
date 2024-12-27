import java.util.*;

class So_Hot_PriorityQueue {
    public int So_Hot_PriorityQueue(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++){
            heap.add(scoville[i]);
        }
        
        int scovil =0;
        
        while(true){
            if(heap.size()<2){
                if(heap.peek() >= K){
                    break;                    
                }
                else{
                    answer = -1;
                    break;
                }
            }
            
            int first = heap.poll();
            int second = heap.poll();
            
            if(first<K || second<K){
                scovil = first  + second * 2;
                heap.add(scovil);
                answer++;
            }
            else{
                break;
            }
        }
        
        
        return answer;
    }
}
import java.util.*; 

class TruckPassedByBridge {
    public int TruckPassedByBridge(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //다리에 대한 큐
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> timeQueue = new ArrayDeque<>();
        Queue<Integer> endQueue = new ArrayDeque<>();
        int currentWeight = 0;
        
            for(int i=0;i<truck_weights.length;i++){
                
                answer++; // 시간 증가.
                
                if(!timeQueue.isEmpty() && (answer-timeQueue.peek()) == bridge_length){
                    timeQueue.poll();
                    currentWeight -= queue.peek();
                    endQueue.offer(queue.poll());
                }
                
                if(currentWeight + truck_weights[i] > weight){
                    //기다려야함
                    i--;
                    continue;
                }
                else{
                    queue.offer(truck_weights[i]); // 7
                    currentWeight += truck_weights[i];
                    timeQueue.offer(answer); // 1
                }
            }
        
        while(!queue.isEmpty()){
            
            answer++; // 시간 증가.
                
                if(!timeQueue.isEmpty() && (answer-timeQueue.peek()) == bridge_length){
                    timeQueue.poll();
                    currentWeight -= queue.peek();
                    endQueue.offer(queue.poll());
                }
        }
        
        return answer;
    }
}
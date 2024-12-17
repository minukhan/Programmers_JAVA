import java.util.HashSet;

class ConnectNumberPlus {
    public int ConnectNumberPlus(int[] elements) {
        int answer = 0;
        int sum =0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1;i<=elements.length;i++){ // 갯수별 조회
            for(int j=0;j<elements.length;j++){ // 
                sum =0;
                for(int k=0;k<i;k++){
                    sum += elements[(k+j) % elements.length];    
                }
                set.add(sum);
            }
        }
        
        answer += set.size();
        
        return answer;
    }
}
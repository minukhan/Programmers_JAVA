import java.util.*;

class Find_PrimeByDFS {
    
    private static char[] arr;
    private static int answer;
    private static HashSet<String> set;
    public int Find_PrimeByDFS(String numbers) {
        
        arr = numbers.toCharArray();
        String tisu="";
        boolean[] visited = new boolean[arr.length];
        set = new HashSet<>();
                
        Maketisu(tisu , visited);
        
        return set.size();
    }
    
    private void Maketisu(String tisu, boolean[] visited){
        
        
        for(int i=0;i<visited.length;i++){
            
            if(!visited[i]){
                
                visited[i] = true; // 방문 처리
                Maketisu(tisu + arr[i],  visited); // 다음 숫자 추가
                visited[i] = false; // 백트래킹 (방문 해제)
            }
        }
        
        if(!tisu.equals("") && checknum(tisu)){
            String number = "" + Integer.parseInt(tisu);
            set.add(number);
            return;
        }
        
    }
    
    private boolean checknum(String number){
        
        int num = Integer.parseInt(number);
        
        boolean check = true;
        
        if(num < 2){
            check = false;
        }
        
        for(int i=2;i<num;i++){
            if(num%i==0){
                check = false;
                break;
            }
        }
        
        return check;
    }
    
    
    
    // dfs 나올 수 있는 경우의 String 을 구해
    
    // 그리고 소수인지 판별하는 함수 
    
    
    
    
}
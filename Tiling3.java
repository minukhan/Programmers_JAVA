class Tiling3 {
    public int solution(int n) {
        int answer = 0;
        
        int div = 1000000007;
        
        long[] arr = new long[5000];
        arr[0] = 1;
        arr[1] = 3;
        n = n/2;
        long number= 0;
        
        for(int i=2;i<=n;i++){
            number = 3 * arr[i-1] % div;
            
            for(int j=i-2;j>=0;j--){
                number = (number + 2 * arr[j]) % div;
            }
            
            if(i==n){
                return (int)number;
            }
            
            arr[i] = number; 
        }
        
        return answer;
    }
}
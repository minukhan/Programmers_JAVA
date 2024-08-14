class Failure_rate {
    public int[] Failure_rate(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] arr = new int[N+2];
        int[] totalarr = new int[N+2];
        double[] failarr = new double[N+2];
        
        for(int i=0;i<stages.length;i++){
            arr[stages[i]]++;
        }
        
        for(int i=1;i<N+1;i++){
            for(int j=0;j<stages.length;j++){
                if(i<=stages[j]){
                    totalarr[i]++;
                }
            }
        }
        
        for(int i=1;i<N+2;i++){
            
            if(arr[i]==0 || totalarr[i]==0){
                failarr[i] = 0;
            }
            else{
                failarr[i] = (double)arr[i]/totalarr[i];
            }
            System.out.println(failarr[i]);
        }
        double max =-1;
        int maxindex =-1;
        for(int k=1;k<N+1;k++){
            max = -1;
            maxindex =-1;
            for(int i=1;i<failarr.length;i++){
                if(max<failarr[i]){
                    max = failarr[i];
                    maxindex = i;
                }
            }
            failarr[maxindex] = -1;
            answer[k-1] = maxindex;
        }
        
        return answer;
    }
}
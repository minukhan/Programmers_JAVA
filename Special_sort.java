class Special_sort {
    public int[] Special_sort(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int min =10001;
        int index=0;
        
        for(int i=0;i<numlist.length;i++){
            for(int j=0;j<numlist.length;j++){
                if(min > Math.abs(numlist[j]-n)){
                    min = Math.abs(numlist[j]-n);
                    index = j;
                    System.out.println(index);
                    
                }
                else if(min ==Math.abs(numlist[j]-n)){
                    if(numlist[index]>numlist[j]){
                        index = index;
                    }
                    else{
                        index = j;
                    }
                }
            }
            answer[i] = numlist[index];
            numlist[index] = 1000000;
            min = 10001;
        }
        
        return answer;
    }
}
class Stringsort2 {
    public int[] Stringsort2(String my_string) {
        int[] arr = new int[my_string.length()];
        int count=0;
        int len = my_string.length();
        
        for(int i=0;i<len;i++){
            arr[i] = my_string.charAt(i) - '0';     // 문자형식으로 받아오는 charAt() 이다. 그래서 숫자로 변환하려면 -'0' 0의 아스키코드를                                                             빼주면 숫자로 변환된다.
            if(arr[i]<10){
                count++;
            }
        }
        
        int[] answer = new int[count];
        
        count=0;
        
        for(int i=0;i<len;i++){
            if(arr[i]<10){
                answer[count] = arr[i];
                count++;
            }
        }
        int temp=0;
        
        for(int i=0;i<count;i++){
            
            for(int j=1;j<count-i;j++){
   
                if(answer[j-1] > answer[j]){
                    temp = answer[j-1];
                    answer[j-1] = answer[j];
                    answer[j] = temp;
                }
                
            }
        }
        
        
        return answer;
    }
}
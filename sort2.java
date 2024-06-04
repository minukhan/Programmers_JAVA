class sort2 {
    public int sort2(String before, String after) {
        int answer = 0;
        char temp;
        int len = before.length();
        char[] arr = new char[len];
        arr = before.toCharArray();
        char[] arrafter = new char[len];
        arrafter = after.toCharArray();        
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(arrafter[j]>arrafter[j+1]){
                    temp=arrafter[j];
                    arrafter[j] = arrafter[j+1];
                    arrafter[j+1] = temp;
                }
            }
        }
        String str1="";
        String str2="";
        
        for(int i=0;i<len;i++){
            str1 += arr[i];
            str2 += arrafter[i];
        }
        
        if(str1.equals(str2)){
            answer = 1;
        }
        
        return answer;
    }
}
class ad_delete {
    public String[] ad_delete(String[] strArr) {
        int count=0;
        
        for(int i=0;i<strArr.length;i++){
            if(!strArr[i].contains("ad")){
                count++;
            }
        }
        
        String[] answer = new String[count];
        count=0;
        for(int i=0;i<strArr.length;i++){
            if(!strArr[i].contains("ad")){
                answer[count]=strArr[i];
                count++;
            }
        }
        
        
        return answer;
    }
}
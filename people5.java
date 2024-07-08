class people5 {
    public String[] people5(String[] names) {
        
        int len = names.length;
        int count=0;
        
        while(len>0){
            count++;
            len = len-5;
        }
        
        len = names.length;
        String[] answer = new String[count];
        count=0;
        
        while(len>0){
            answer[count++] = names[names.length-len];
            len = len-5;
        }

        return answer;
    }
}
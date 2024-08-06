class Year_2016 {
    public String Year_2016(int a, int b) {
        String answer = "";
        String[] arr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int count=0;
        
        for(int i=1;i<a;i++){
            switch(i){
                case 2:
                    count+=29;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    count+=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    count+=30;
                    break;
            }
        }
        count+=b;
        
        answer = arr[(count+4)%7];
        
        return answer;
    }
}
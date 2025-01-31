class DartGame_1 {
    public int DartGame_1(String dartResult) {
        int answer = 0;
        int[] numberarr = new int[3];
        String num = "";
        char dart;
        int score=0;
        int index =0;
        boolean next = false;
        
        for(int i=0;i<dartResult.length();i++){
            dart = dartResult.charAt(i);
            if(Character.isDigit(dart)){
                num+=dart;
            }
            else if(dart == 'S'){
                score = Integer.parseInt(num);
                numberarr[index] = score;
                next=true;
                num= "";
            }
            else if(dart == 'D'){
                score = Integer.parseInt(num);
                numberarr[index] = score * score;
                next=true;
                num= "";
            }
            else if(dart == 'T'){
                score = Integer.parseInt(num);
                numberarr[index] = score * score * score;
                next=true;
                num= "";
            }
            if(i+1!=dartResult.length() && dartResult.charAt(i+1)=='*'){
                numberarr[index] = numberarr[index] * 2;
                if(index!=0){
                    numberarr[index-1] = numberarr[index-1] * 2;
                }
            }
            if(i+1!=dartResult.length() && dartResult.charAt(i+1)=='#'){
                numberarr[index] = numberarr[index] * -1;
            }
            if(next){
                next= false;
                index++;
            }
        }
        
        for(int i=0;i<numberarr.length;i++){
            answer += numberarr[i];
        }
        
        return answer;
    }
}
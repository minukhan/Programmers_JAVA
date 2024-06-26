class Ailen_dictionary {
    public int Ailen_dictionary(String[] spell, String[] dic) {
        int answer = 2;
        char[] combine = new char[spell.length];
        char temp=' '; //빈 문자 리터럴이 허용되지 않는다.
        String com="";
        String com2="";
        
        for(int i=0;i<spell.length;i++){
            combine[i] = spell[i].charAt(0);
        }
        
        for(int i=0;i<combine.length;i++){
            for(int j=0;j<combine.length-1-i;j++){
                if(combine[j]>combine[j+1]){
                    temp = combine[j];
                    combine[j] = combine[j+1];
                    combine[j+1] = temp;
                }
            }
        }
        for(int i=0;i<combine.length;i++){
            com += combine[i];
        }
        
        for(int i=0;i<dic.length;i++){
            if(dic[i].length()==spell.length){
                combine = dic[i].toCharArray();
                for(int k=0;k<spell.length;k++){
                    for(int j=0;j<spell.length-1-k;j++){
                        if(combine[j]>combine[j+1]){
                            temp = combine[j];
                            combine[j] = combine[j+1];
                            combine[j+1] = temp;
                        }
                    }
                }
                
                for(int y=0;y<combine.length;y++){
                    com2 +=combine[y];
                }
                if(com.equals(com2)){
                    answer = 1;
                    break;
                }
                com2="";
            }
        }
        
        
        return answer;
    }
}
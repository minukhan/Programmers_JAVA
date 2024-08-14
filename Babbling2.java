class Babbling2 {
    public int Babbling2(String[] babbling) {
        int answer = 0;
        boolean yes = true;
        int repeat = 0;
        
        for(int i=0;i<babbling.length;i++){
            repeat = 0;
            yes = true;
            
            for(int j=0;j<babbling[i].length();j++){
                if('y'==babbling[i].charAt(j)){
                    if(repeat==1){
                        
                        yes = false;
                        break;
                    }
                    if(j+1>=babbling[i].length()){
                        yes = false;
                        break;
                    }
                    if('e'!=babbling[i].charAt(j+1)){
                        yes = false;
                        break;
                    }
                    j = j+1;
                    repeat = 1;
                }
                else if('a'==babbling[i].charAt(j)){
                    if(repeat==2){
                        yes = false;
                        break;
                    }
                    if(j+2>=babbling[i].length()){
                        yes = false;
                        break;
                    }
                    if('y'!=babbling[i].charAt(j+1) || 'a'!=babbling[i].charAt(j+2)){
                        yes = false;
                        break;
                    }
                    j = j+2;
                    repeat = 2;
                    
                }
                else if('w'==babbling[i].charAt(j)){
                    if(repeat==3){
                        yes = false;
                        break;
                    }
                    if(j+2>=babbling[i].length()){
                        yes = false;
                        break;
                    }
                    if('o'!=babbling[i].charAt(j+1) || 'o'!=babbling[i].charAt(j+2)){
                        yes = false;
                        break;
                    }
                    j = j+2;
                    repeat = 3;
                }
                else if('m'==babbling[i].charAt(j)){
                    if(repeat==4){
                        yes = false;
                        break;
                    }
                    if(j+1>=babbling[i].length()){
                        yes = false;
                        break;
                    }
                    if('a'!=babbling[i].charAt(j+1)){
                        yes = false;
                        break;
                    }
                    j = j+1;
                    repeat = 4;
                    
                }
                else{
                    yes = false;
                    break;
                }
            }
            
            if(yes){
                answer++;
            }
        }
        
        return answer;
    }
}
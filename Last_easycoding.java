class Last_easycoding {
    public int Last_easycoding(String[] babbling) {
        int answer = 0;
        String kid="";
        int count=0;
        
        for(int i=0;i<babbling.length;i++){
            
                kid = babbling[i];
                
                while(kid.length()>count){
                    if(kid.charAt(count)=='a'){
                        if(kid.length()>count+2){
                            if(kid.charAt(count+1)=='y' && kid.charAt(count+2)=='a'){
                                count = count+3;
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    else if(kid.charAt(count)=='y'){
                        
                        if(kid.length()>count+1){
                            if(kid.charAt(count+1)=='e'){
                                count = count+2;
                                System.out.println(count);
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    else if(kid.charAt(count)=='w'){
                        if(kid.length()>count+2){
                            if(kid.charAt(count+1)=='o' && kid.charAt(count+2)=='o'){
                                count = count+3;
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    else if(kid.charAt(count)=='m'){
                        if(kid.length()>count+1){
                            if(kid.charAt(count+1)=='a'){
                                count = count+2;
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break;
                    }
                    
                    if(kid.length()==count){
                        answer++;
                        break;
                    }
                }
                
                count=0;
            
            
        }
        
        return answer;
    }
}
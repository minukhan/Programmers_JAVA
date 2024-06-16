class Ihateenglish {
    public long Ihateenglish(String numbers) {
        String k ="";
        long answer=0;
        String str="";
        int index =0;
        
        char[] arr = numbers.toCharArray();
        
        for(int i=0;i<numbers.length();i++){
            if(arr[i]=='z'){
                str ="";
                for(int j=0;j<4;j++){
                    if(i>numbers.length()-1){
                        break;
                    }
                    str += arr[i];
                    i++;
                }
                if(str.equals("zero")){
                    k += "0";
                    i--;
                }
                else{
                    i = i-4;
                }
            }
            else if(arr[i]=='o'){
                str ="";
                index = i;
                for(int j=0;j<3;j++){
                    if(i>numbers.length()-1){
                        break;
                    }
                    str += arr[i];
                    i++;
                }
                if(str.equals("one")){
                    k += "1";
                    i--;
                }
                else{
                    i = index;
                }
            }
            else if(arr[i]=='e'){
                str ="";
                index = i;
                
                for(int j=0;j<5;j++){
                    if(i>numbers.length()-1){
                        break;
                    }
                    str += arr[i];
                    i++;
                }
                if(str.equals("eight")){
                    k += "8";
                    i--;
                }
                else{
                    i = index;
                }
            }
            else if(arr[i]=='n'){
                str ="";
                index = i;
                for(int j=0;j<4;j++){
                    if(i>numbers.length()-1){
                        break;
                    }
                    str += arr[i];
                    i++;
                }
                if(str.equals("nine")){
                    k += "9";
                    i--;
                }
                else{
                    i = index;
                }
            }
            else if(arr[i]=='t'){
                str ="";
                index = i;
                if(arr[i+1]=='w'){
                    for(int j=0;j<3;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("two")){
                        k += "2";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
                else if(arr[i+1]=='h'){
                    for(int j=0;j<5;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("three")){
                        k += "3";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
            }
            else if(arr[i]=='f'){
                str ="";
                index = i;
                if(arr[i+1]=='o'){
                    for(int j=0;j<4;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("four")){
                        k += "4";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
                else if(arr[i+1]=='i'){
                    for(int j=0;j<4;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("five")){
                        k += "5";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
            }
            else if(arr[i]=='s'){
                str ="";
                index = i;
                if(arr[i+1]=='i'){
                    for(int j=0;j<3;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("six")){
                        k += "6";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
                else if(arr[i+1]=='e'){
                    for(int j=0;j<5;j++){
                        if(i>numbers.length()-1){
                            break;
                        }
                        str += arr[i];
                        i++;
                    }   
                    if(str.equals("seven")){
                        k += "7";
                        i--;
                    }
                    else{
                        i = index;
                    }
                }
            }
        }
        answer = Long.parseLong(k);
        return answer;
    }
}
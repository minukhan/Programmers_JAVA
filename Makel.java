class Makel {
    public String Makel(String myString) {
    String answer = "";
    
    char[] arr = new char[myString.length()];
    
    for(int i=0;i<myString.length();i++){
    if(myString.charAt(i)<'l'){
    arr[i] = 'l';
    }
    else{
    arr[i] = myString.charAt(i);
    }
    }
    
    for(int i=0;i<arr.length;i++){
    answer += arr[i];
    }
    
    return answer;
    }
    }
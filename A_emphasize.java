class A_emphasize {
    public String A_emphasize(String myString) {
        String answer = "";
        
        answer = myString.toLowerCase();
        answer = answer.replace("a","A");
        
        return answer;
    }
}
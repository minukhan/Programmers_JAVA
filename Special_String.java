class Special_String {
    public String Special_String(String my_string, String alp) {
        String answer = "";
        String Stralp ="";
        
        Stralp = alp.toUpperCase();
        answer = my_string.replace(alp,Stralp);
        
        return answer;
    }
}
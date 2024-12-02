class Making_Hamburger {
    public int Making_Hamburger(int[] ingredient) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<ingredient.length;i++){
            sb.append(ingredient[i]);
        }
        
        for(int i=0;i<sb.length();i++){
            if((i+3)<sb.length()){
                if(sb.charAt(i)=='1' && sb.charAt(i+1)=='2' && sb.charAt(i+2)=='3' && sb.charAt(i+3)=='1'){
                    answer++;
                    sb.delete(i,i+4);
                    i = Math.max(i-4, -1);
                }
            }
        }
        
        return answer;
    }
}

// 자료구조 스택, StringBuilder
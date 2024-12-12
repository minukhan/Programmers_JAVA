class Max_Min_find {
    public String Max_Min_find(String s) {
        String answer = "";
        int maxnum = -6000000;
        int minnum = 50000000;
        
        String[] MaxminArray = s.split(" ");
        
        
        for(int i=0;i<MaxminArray.length;i++){
            maxnum = Math.max(maxnum,Integer.parseInt(MaxminArray[i]));
            minnum = Math.min(minnum,Integer.parseInt(MaxminArray[i]));
        }
        
        System.out.println("maxnum : "+ maxnum);
        System.out.println("minnum : "+ minnum);
        answer = "" + minnum + " " + maxnum;
        
        return answer;
    }
}
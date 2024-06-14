class rock {

    public String rock(String rsp) {

        String answer = "";

        char [] compare = rsp.toCharArray();

        

        for(int i=0;i<compare.length;i++){

           if(compare[i]=='0') answer+='5';

           else if(compare[i]=='2') answer+='0';

           else if(compare[i]=='5') answer+='2';

        }

        

        return answer;

    }

}
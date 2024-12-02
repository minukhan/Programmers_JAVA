class NumberFriend {

    public String NumberFriend(String X, String Y) {

        String answer = "";

        

        int[] Xarr = new int[10];

        int[] Yarr = new int[10];

        int[] answerArr = new int[10];

        

        // char 배열로 전환

        char[] XArray = X.toCharArray();

        char[] YArray = Y.toCharArray();

        

        for(int i=0;i<XArray.length;i++){

            Xarr[(XArray[i]-'0')]++;

        }

        for(int i=0;i<YArray.length;i++){

            Yarr[(YArray[i]-'0')]++;

        }

        

        

        // answerArr 에 중복된 숫자 개수 저장

        for(int i=0;i<10;i++){

            answerArr[i] = Math.min(Xarr[i],Yarr[i]);

        }

        

        //큰 수부터 내려오면서 0 보다 크다면 추가

        StringBuilder sb = new StringBuilder();

        

        int k=answerArr.length-1;

        while(k>=0){

            if(answerArr[k]>0){

                sb.append(k);

                answerArr[k]--;

                continue;

            }

            else{

                k--;

            }

        }

        

        answer = sb.toString();

        

        //예외처리 아무것도 없으면 -1, 00 인경우 0으로 전환

        if(answer.isEmpty()){

            answer = "-1";

        }

        

        if(answer.matches("0+")){

            answer = "0";

        }

        

        return answer;

    }

}
class decodement {

    public String decodement(String cipher, int code) {

        String answer = "";

        char [] arr = cipher.toCharArray();

        int k =0;

        for(int i=code-1;i<cipher.length();i=i+code){

            answer = answer + arr[i];

        }

        return answer;

    }

}
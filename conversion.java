class conversion {

    public String conversion(String my_string) {

        String answer = "";

        char[] arr = my_string.toCharArray();

        char newChar;

        char ch ;

        int ascii =0;

        

        for(int i=0;i<my_string.length();i++){

            

            ascii = (int)arr[i];

            ch = arr[i];

            

            if(ascii<97){

                newChar = (char)(ch+32);

                answer = answer + newChar;

            }

            else{

                newChar = (char)(ch-32);

                answer = answer + newChar;

            }

        }

        

        

        return answer;

    }

}
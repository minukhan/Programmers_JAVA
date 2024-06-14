class String_calculation {
    public int String_calculation(String my_string) {
        int answer = 0;
        int count=0;
        int charcount=0;
        
        String[] arr = my_string.split(" ");
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("+") || arr[i].equals("-")){
                charcount++;
            }
            else{
                count++;
            }
        }
        
        int[] num = new int[count];
        char[] plmi = new char[charcount];
        
        count=0;
        charcount=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("+") || arr[i].equals("-")){
                plmi[charcount] = arr[i].charAt(0);
                charcount++;
            }
            else{
                num[count] = Integer.parseInt(arr[i]);
                count++;
            }
        }
        int kk=0;
        kk=charcount;
        
        count=1;
        charcount=0;
        answer += num[0];

        System.out.println(kk);
        while(kk>0){
            if(plmi[charcount]=='+'){
                answer = answer + num[count];
                count++;
                charcount++;
            }
            else if(plmi[charcount]=='-'){
                answer = answer - num[count];
                count++;
                charcount++;
            }
            
            kk--;
        }

        return answer;
    }
}
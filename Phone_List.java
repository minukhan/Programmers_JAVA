import java.util.Arrays;

class Phone_List {
    public boolean Phone_List(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
            for(int j=0;j<phone_book.length-1;j++){
                    if(phone_book[j+1].startsWith(phone_book[j])){
                        answer = false;
                        break;
                    }
            }
        
        return answer;
    }
}
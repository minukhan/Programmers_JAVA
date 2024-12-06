import java.util.*;

class StringBuilderStudy {
    public String StringBuilderStudy(String new_id) {
        String answer = "";
        //1단계
        String Lower = new_id.toLowerCase();
        
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(Lower);
        
        String special = "~!@#$%^&*()=+[{]}:?,<>/";
        
        char[] specialChar = special.toCharArray();
        
        
        //2단계
        for(int i=0;i<sb.length();i++){
            for(int j=0;j<specialChar.length;j++){
                if(sb.charAt(i)==specialChar[j]){
                    sb.deleteCharAt(i);
                    i--;
                    break;
                }
            }
        }
        System.out.println( "2 : " +sb);
        
        //3단계
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='.' && (i+1)<sb.length() && sb.charAt(i+1)=='.'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println( "3 : " +sb);
        
        //4단계
        if(sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println( "4 : " +sb);
        
        //5단계
        if(sb.length()==0){
            sb.append("a");
        }
        System.out.println( "5 : " +sb);
        
        //6단계
        if(sb.length()>14){
            sb.delete(15,sb.length());
            
            if(sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
            }
            if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
            
        }
        System.out.println( "6 : " +sb);
        // 마지막 단계
        if(sb.length()<3){
            while((sb.length()!=3)){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        System.out.println( "7 : " +sb);
        
        answer = sb.toString();
        
        return answer;
    }
}
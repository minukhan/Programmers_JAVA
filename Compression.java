import java.util.*;

class Compression {
    public int[] Compression(String msg) {
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("P");
        list.add("Q");
        list.add("R");
        list.add("S");
        list.add("T");
        list.add("U");
        list.add("V");
        list.add("W");
        list.add("X");
        list.add("Y");
        list.add("Z");
        
        String current = "";
        String next = "";
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(int i=0;i<msg.length();i++){
            if(i+1 == msg.length()){
                current += msg.charAt(i);
                answerList.add(list.indexOf(current)+1);
                
                break;
            }
            else{
                current += msg.charAt(i);
                next = current + msg.charAt(i+1);
            }
            if(list.contains(next)){
                continue;
            }
            else if(list.contains(current)){
                
                list.add(next);
                answerList.add(list.indexOf(current)+1);
                current="";
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
}
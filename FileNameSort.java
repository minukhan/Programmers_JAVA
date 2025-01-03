import java.util.*;

class FileNameSort {
    public String[] FileNameSort(String[] files) {
        
        String Head;
        String num;
        int numIndexStart=0;
        int numIndexEnd=0;
        
        List<String[]> list = new ArrayList<>();
        
        for(int i=0;i<files.length;i++){
            Boolean check = false;
            numIndexStart=0;
            numIndexEnd=0;
            
            for(int j=0;j<files[i].length();j++){
                
                if( files[i].charAt(j)=='0' || files[i].charAt(j)=='1' || files[i].charAt(j)=='2' || files[i].charAt(j)=='3' || files[i].charAt(j)=='4' || files[i].charAt(j)=='5' || files[i].charAt(j)=='6' || files[i].charAt(j)=='7' || files[i].charAt(j)=='8' || files[i].charAt(j)=='9'){
                    
                    if(!check && j==files[i].length()-1){
                        numIndexStart = j;
                        numIndexEnd = j+1;
                        break;
                    }
                    else if(check && j==files[i].length()-1){
                        numIndexEnd = j+1;
                        break;
                    }
                    if(check){
                        continue;
                    }
                    numIndexStart = j;
                    check = true;
                }
                else if(check){
                    numIndexEnd = j;
                    break;
                }
            }
            
            Head = files[i].substring(0 , numIndexStart);
            num = files[i].substring(numIndexStart , numIndexEnd);
            
            System.out.println("i : "+i);
            
            System.out.println("Head : "+Head);
            System.out.println("num : "+num);
            
            String[] file = new String[4];
            
            file[0] = String.valueOf(i);
            file[1] = Head;
            file[2] = num;
            file[3] = files[i];
            list.add(file);
            
        }
         list.sort((o1,o2) -> {
                
                int headsort = o1[1].toLowerCase().compareTo(o2[1].toLowerCase());
                if(headsort != 0){
                    return headsort;
                }
                
                int numsort = Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
                if(numsort != 0){
                    return numsort;
                }
                
                int finalsort = Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
                    return finalsort;
            });
        
        String[] answer = new String[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i)[3];
        }
        
        
        return answer;
    }
}
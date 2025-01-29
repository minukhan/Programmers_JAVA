import java.io.*;
import java.util.*;

public class GPT_Sort {

    public static void GPT_Sort(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }


        list.sort((o1, o2) -> {

            String[] aParts = o1.split("\\.");
            String[] bParts = o2.split("\\.");

            int a = Integer.parseInt(aParts[0]); 
            int b = Integer.parseInt(bParts[0]); 

            if(a>b){
                return 1;
            }
            else if(b>a){
                return -1;
            }
            else{
                
                int asize = aParts.length;
                int bsize = bParts.length;

                if(asize==1 && bsize==1){
                    return 0;
                }
                else if( asize==1 ){
                    return -1;
                }
                else if( bsize==1){
                    return 1;
                }
                else{
                    
                    int aFraction = Integer.parseInt(aParts[1]);
                    int bFraction = Integer.parseInt(bParts[1]);
                    
                    if(aFraction > bFraction){
                        return 1;
                    }
                    else if(aFraction < bFraction){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        
        });

        for(int i=0;i<list.size();i++){
             System.out.println(list.get(i));   
        }
    }
}

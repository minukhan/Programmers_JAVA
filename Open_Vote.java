import java.io.*;
import java.util.*;

public class Open_Vote {

    public static void Open_Vote(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int memeberCount = Integer.parseInt(reader.readLine());

        for(int i=0;i<memeberCount;i++){
            int count = Integer.parseInt(reader.readLine());

            int fivecount = count/5;
            int divisionCount = count%5;

            for(int j=0;j<fivecount;j++){
                System.out.print("++++ ");
            }
            for(int j=0;j<divisionCount;j++){
                System.out.print("|");
            }

            System.out.println("");
            
            
        }
        
    
    }
}

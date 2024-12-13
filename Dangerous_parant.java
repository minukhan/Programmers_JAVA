import java.io.*;
import java.util.*;

public class Dangerous_parant {

    public static void Dangerous_parant(String[] args) throws IOException {

        int answer =0;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputData = reader.readLine();

        String[] intputArray = inputData.split(" ");
        int front = Integer.parseInt(intputArray[1]);
        int back = Integer.parseInt(intputArray[0]);
        int distance = Integer.parseInt(intputArray[2]);
        int remainDistance = distance;
        int temp =0;

        boolean frontBack = false;
        boolean finish = false;
        while(true){

            if(frontBack){
                answer += front;
                frontBack = false;
                
            }
            else{
                if((remainDistance - back) <= 0 && !finish ){

                    
                    finish = true;
                    temp = front;
                    front = back;
                    back = temp;
                    
                    answer += remainDistance;

                    answer += back;
                    
                    remainDistance = distance - back;
                        
                }
                else{
                    if((remainDistance - back) <= 0 && finish){
                        answer += remainDistance;
                        break;
                    }
                    answer += back;  
                    
                    remainDistance = remainDistance - back;
                }
                frontBack = true;
            }
            
        }
        System.out.print(answer);
    
    }
}

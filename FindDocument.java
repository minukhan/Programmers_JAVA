import java.util.*;

import java.lang.*;

import java.io.*;


// The main method must be in a class named "Main".

class FindDocument {

        public static void FindDocument(String[] args) throws Exception{

            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

            int answer=0;

            String input = br.readLine();

            String find = br.readLine();

                int startIndex = 0;

            int findIndex = 0;

            while(true){

              findIndex = input.indexOf(find, startIndex);


                if(findIndex< 0){

                    break;

                }

                answer++;

                    startIndex = findIndex + find.length();

            }

                

            

            System.out.println(answer);

            

    }
}
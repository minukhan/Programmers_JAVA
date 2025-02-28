import java.util.*;

import java.lang.*;

import java.io.*;


// The main method must be in a class named "Main".

class Anergram_Making {

        public static void Anergram_Making(String[] args) throws Exception{


            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

            int[] countA = new int[26];

            String input1 = br.readLine();


            for(int i=0;i<input1.length();i++){

                countA[input1.charAt(i) - 'a']++;

            }

            int[] countB = new int[26];

            String input2 = br.readLine();

            for(int i=0;i<input2.length();i++){

                countB[input2.charAt(i) - 'a']++;

            }

            int answer=0;

            

            for(int i=0;i<26;i++){

                answer+= Math.abs(countA[i] - countB[i]);    

            }

            

            System.out.println(answer);

            

    }

}
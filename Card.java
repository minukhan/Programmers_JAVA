import java.util.*;
import java.lang.*;
import java.io.*;

class Card {
    public static void Card(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(Long.parseLong(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());

        int count =1;
        int maxCount = 0;
        Long result =0L;
        
        for(int i=1;i<n;i++){
            
            if(list.get(i-1).equals(list.get(i))){
                count++;
            }
            else{
                if(maxCount < count ){
                    maxCount = count;
                    result = list.get(i-1);
                }
                count =1;
            }
            
        }

        if(maxCount < count ){
                    maxCount = count;
                    result = list.get(n-1);
                }
        
        System.out.println(result);
        
    }
}
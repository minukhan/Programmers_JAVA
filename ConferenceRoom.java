import java.util.*;
import java.lang.*;
import java.io.*;

class ConferenceRoom {

    static class Room{
        int start;
        int end;

        public Room(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    
    public static void ConferenceRoom(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Room> list = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Room(start, end));
            
        }

        list.sort((o1,o2) -> {
            if(o1.end != o2.end){
                return o1.end - o2.end;
            }

            return o1.start - o2.start;
        });

        int currentTime=0;
        int count=0;

        for(int i=0;i<list.size();i++){
            if(currentTime > list.get(i).start) continue;

            currentTime = list.get(i).end;
            count++;
        }

        System.out.println(count);

        
    }
}
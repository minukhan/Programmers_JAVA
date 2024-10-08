import java.util.HashMap;

import java.util.Set;


class Runing {

    public String[] Runing(String[] players, String[] callings) {

        

//         int index = -1;

//         String temp ="";

        

//         for(int j=0;j<callings.length;j++){

//             for(int i=0; i<players.length;i++){

//                 if(players[i].equals(callings[j])){

//                     index = i;

//                     break;

//                 }

//             }

            

//             temp="";

            

//             if(index!=-1){

//                 temp = players[index-1];

//                 players[index-1] =  players[index];

//                 players[index] = temp;

//             }

//             index=-1;

//         }

        

        

        HashMap<String , Integer> map = new HashMap<>();

        

        String temp ="";

        String firsttemp ="";

        int index=-1;

        

        for(int i=0;i<players.length;i++){

            map.put(players[i],i);

        }

        

        for(int i=0;i<callings.length;i++){

            index = map.get(callings[i]);

            

            if((index-1)>=0){

                temp = players[index-1];

                firsttemp = players[index];

                players[index-1] = players[index];

                players[index] = temp;

                map.put(firsttemp,index-1);

                map.put(temp,index);

            }

        }

        

        

        return players;

    }

}

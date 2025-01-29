import java.io.*;
import java.util.*;

public class TreeAttack {

    public static void TreeAttack(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int y = Integer.parseInt(size[0]);
        int x = Integer.parseInt(size[1]);

        int[][] input = new int[y][x];
        
        for(int i=0;i<y;i++){
            String[] row = br.readLine().split(" ");
            for(int j=0;j<x;j++){
                input[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] firstAttack = br.readLine().split(" ");
        String[] secondAttack = br.readLine().split(" ");

        int firstAttackInit = Integer.parseInt(firstAttack[0])-1;
        int firstAttackEnd = Integer.parseInt(firstAttack[1])-1;
        int secondAttackInit = Integer.parseInt(secondAttack[0])-1;
        int secondAttackEnd = Integer.parseInt(secondAttack[1])-1;

        List<Integer> firstList = new ArrayList<>();
        for(int i=firstAttackInit;i<=firstAttackEnd;i++){
            firstList.add(i);    
        }   
        List<Integer> secondList = new ArrayList<>();
        for(int i=secondAttackInit;i<=secondAttackEnd;i++){
            secondList.add(i);    
        }

        for(int i=0;i<x;i++){
            for(int j=firstAttackInit;j<=firstAttackEnd;j++){
                if(input[j][i]==1 && firstList.contains(j)){
                    firstList.remove(Integer.valueOf(j));
                    input[j][i] = 0;
                }
            }
        }
        for(int i=0;i<x;i++){
            for(int j=secondAttackInit;j<=secondAttackEnd;j++){
                if(input[j][i]==1 && secondList.contains(j)){
                    secondList.remove(Integer.valueOf(j));
                    input[j][i] = 0;
                }
            }
        }

        int answer= 0;
        
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(input[i][j]==1){
                    answer++;
                }
            }
        }

        System.out.println(answer);
        
        
    }
}

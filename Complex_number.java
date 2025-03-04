import java.util.*;
import java.lang.*;
import java.io.*;

class Complex_number {

    public static int[][] input;
    public static int count;
    public static int groupCount;
    public static int[][] check = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public static void Complex_number(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());

        input = new int[n][n];
        count =0;
        ArrayList<Integer> grouptotal = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String number=  br.readLine();
            for(int j=0;j<number.length();j++){
                input[i][j] = number.charAt(j) - '0';
            }
        }
        groupCount =0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(input[i][j] == 1){
                    
                    dfs(j,i);
                    groupCount++;
                    grouptotal.add(count);
                    
                    count =0;
                }
            }
        }

        System.out.println(groupCount);
        grouptotal.sort(Comparator.naturalOrder());
        for(int value : grouptotal){
            System.out.println(value);
        }
    }

    public static void dfs(int x, int y){

        count++;
        input[y][x] = groupCount+2;

        for(int i=0;i<check.length;i++){
            int dy = y + check[i][0];
            int dx = x + check[i][1];

            if( dy<0 || dy>=input.length || dx<0 || dx>=input.length) continue;
            
            if(input[dy][dx] == 1){
                dfs(dx,dy);
            }
        }
    }

}
import java.util.*;
import java.lang.*;
import java.io.*;

class boj_15686 {

    public static int[][] road;
    public static ArrayList<Spot> list;
    public static ArrayList<Spot> house;
    public static int N;
    public static int M;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    
    static class Spot{
        int x;
        int y;
        public Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        road = new int[N+1][N+1];

        list = new ArrayList<>();
        house = new ArrayList<>();
        
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j=1;j<N+1;j++){
                road[i][j] = Integer.parseInt(st.nextToken());

                if(road[i][j] == 2){
                    list.add(new Spot(j,i));
                }
                else if(road[i][j] == 1){
                    house.add(new Spot(j,i));
                }
            }
        }

        visited = new boolean[list.size()];

        dfs(0, 0, new ArrayList<Spot>());

        System.out.println(answer);
    }
    public static void dfs(int index, int count, ArrayList<Spot> chicken){
        
        if(count == M){
            int sum = distance(chicken);
            if( sum < answer){
                answer = sum;
            }
        }

        for(int i=index;i<list.size();i++){

            if(visited[i]) continue;

            ArrayList<Spot> nextArr = new ArrayList<>();

            for(Spot spot : chicken){
                nextArr.add(spot);    
            }
            nextArr.add(list.get(i));
            
            visited[i] = true;
            dfs(i+1 ,count+1, nextArr);
            visited[i] = false;
            
        }
    }

    public static int distance(ArrayList<Spot> chicken){

        int sum = 0;
        
        for(Spot spot : house){
            int x = spot.x;
            int y = spot.y;

            int minDis = Integer.MAX_VALUE;
            
            for(Spot chic : chicken){
                int chicX = chic.x;
                int chicY = chic.y;

                minDis = Math.min(minDis, Math.abs(x - chicX) + Math.abs(y - chicY));
            }
            sum += minDis;
        }

        return sum;
    }
}
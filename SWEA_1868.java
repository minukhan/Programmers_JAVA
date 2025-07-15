import java.util.*;
import java.io.*;

public class SWEA_1868
{
	public static char[][] map;
	public static int N;
	
	public static int[] dy = {-1,-1,-1,0,0,0,1,1,1};
	public static int[] dx = {-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int index =1;
		
		while(T-- > 0) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new char[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for(int j=0;j<N;j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			int count = 0;
			
			//0인곳 먼저 진행
			for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (map[i][j] == '.' && starCount(i, j) == 0) {
	                    simulation(i, j);
	                    count++;
	                }
	            }
	        }
			
			for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (map[i][j] == '.') {
	                    count++;
	                }
	            }
	        }
			
			
			
			sb.append("#").append(index).append(" ").append(count).append("\n");
			
			
			index++;
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation(int y, int x) {
        int current = starCount(y, x);
        map[y][x] = (char) (current + '0');

        if (current == 0) {
            for (int i = 0; i < 9; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (map[ny][nx] != '.') continue;

                simulation(ny, nx);
            }
        }
    }
	
	public static int starCount(int y, int x) {

		int count = 0;
		
		for(int i=0;i<9;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if(map[ny][nx] != '*') continue;
			
			count++;
		}
		
		return count;
	}

}



import java.util.*;
import java.io.*;

// 점원은 1명 이상으로 되어있다. 
// 그러니까 B 보다는 커야하는데 큰것중에서 가장 작은거.
// 모두 탐색은 해야함. 
// 조합으로 선택하고 아니면 중복 허용하지 않고 조합?

public class SWEA_1486
{
	public static int N;
	public static int B;
	public static int min;
	public static int[] member;

	
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int index =1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			
			 N = Integer.parseInt(st.nextToken());
			 B = Integer.parseInt(st.nextToken());
			
			 member = new int[N];
			 st = new StringTokenizer(br.readLine());
			 for(int i=0;i<N;i++) {
				 member[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 min = Integer.MAX_VALUE;
			 dfs(0,0,0);	
			
			
			sb.append("#").append(index).append(" ").append(min).append("\n");
			
			index++;
		}
		
		System.out.println(sb.toString());
		
	
	}
	
	public static void dfs(int count, int index, int sum) {
				
		if(sum >= B) {
			min = Math.min(min, (int) Math.abs(sum - B));
			return;
		}

		if(count == N) {
			return ;
		}
		
		
		for(int i=index;i<N;i++) {
			dfs(count + 1, i+1, sum + member[i]);
		}
		
	}
}
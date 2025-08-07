


import java.util.*;

class SendTime {
	
	public class Node{
		int index;
		int dist;
		public Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
	}
	
	public class Edge{
		int index;
		int weight;
		public Edge(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
	public ArrayList<Edge>[] list;
	public int[] dist;
	public int NodeCount =0;
	
	public void initDijkstra() {
		dist = new int[NodeCount * 100 + 31];	
		Arrays.fill(dist, Integer.MAX_VALUE);
	}
	
	
	public void init(int N, int K, int mNodeA[], int mNodeB[], int mTime[])
	{
		NodeCount = N;
		
		initDijkstra();
		// 그래프 초기화 
		list = new ArrayList[N * 100 + 31];
		for(int i=1;i<N * 100 + 31;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<K;i++) {
			int from = mNodeA[i];
			int to = mNodeB[i];
			int weight = mTime[i];
			
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}
	}

	public void addLine(int mNodeA, int mNodeB, int mTime)
	{
		// 하나만 추가
		 list[mNodeA].add(new Edge(mNodeB, mTime));
		 list[mNodeB].add(new Edge(mNodeA, mTime));
		 
	}

	public void removeLine(int mNodeA, int mNodeB)
	{	// 하나만 제거
	
		list[mNodeA].removeIf(e -> e.index == mNodeB);
		list[mNodeB].removeIf(e -> e.index == mNodeA);
		
	}

	public int checkTime(int mNodeA, int mNodeB)
	{
		
		initDijkstra();
		PriorityQueue<Node> queue = new PriorityQueue<>(
				(o1, o2) -> Integer.compare(o1.dist, o2.dist)
		);
		
		queue.add(new Node(mNodeA, 0));
		dist[mNodeA] = 0;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			if(dist[node.index] != node.dist) continue;
			if(node.index == mNodeB) {
				return node.dist;
			}
			
			for(Edge e : list[node.index]) {
				
				if(dist[e.index] > dist[node.index] + e.weight) {
					dist[e.index] = dist[node.index] + e.weight;
					queue.add(new Node(e.index, dist[e.index]));
				}
			}
		}
		
		return dist[mNodeB];
	}
}

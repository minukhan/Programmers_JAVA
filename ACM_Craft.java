import java.util.*;
import java.lang.*;
import java.io.*;

class ACM_Craft {

    public static int[] time;
    public static int[] inDegree;
    public static boolean[] visited;
    public static int count=0;
    public static int X;
    public static ArrayList<Integer>[] graph;
    public static int[] dpTime;
    public static BufferedReader br;
    
    public static void ACM_Craft(String[] args) throws IOException{

        br =new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i=0;i<test;i++){
            process();
        }
    }

    public static void process()  throws IOException{
        

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 시간 배열 생성 및 저장
        st = new StringTokenizer(br.readLine());
        time = new int[N+1];
        for(int i=1;i<N+1;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        // 그래프 생성 및 초기화
        graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        // inDegree 배열 선언
        inDegree = new int[N+1];

        //visieted 배열 선언
        visited = new boolean[N+1];
        
        //그래프 간선들 추가 방향그래프
        for(int i=1;i<K+1;i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to]++;
        }

        X = Integer.parseInt(br.readLine());
        dpTime = new int[N+1];

        bfs();
        
        System.out.println(dpTime[X]);
    }


    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<inDegree.length;i++){
            if(inDegree[i] ==0){
                queue.add(i);
                dpTime[i] = time[i];
            }
        }

        // 목표 건물이 진입차수 0이라면(선행 건물이 없다면) 바로 처리
        if (inDegree[X] == 0) {
            dpTime[X] = time[X];
            return;
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int value : graph[node]){
                inDegree[value]--;
                dpTime[value] = Math.max(dpTime[value], dpTime[node] + time[value]);
                
                if(inDegree[value]==0){
                    queue.add(value);
                }
            }
        }
    }

}
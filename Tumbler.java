import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static boolean[][][] visited;
    public static int[] limit;
    public static HashSet<Integer> set;
    
    static class Node{
        int a;
        int b;
        int c;

        public Node(int a,int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201][201];
        set = new HashSet<>();
        
        limit = new int[3];
        limit[0] = A;
        limit[1] = B;
        limit[2] = C;
        
        dfs(new Node(0,0,C));

        ArrayList<Integer> result = new ArrayList<>();
        
        for(int value : set){
            result.add(value);
        }
        StringBuilder sb = new StringBuilder();
        
        result.sort(Comparator.naturalOrder());
        for(int value : result){
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(Node node){
        int a = node.a;
        int b = node.b;
        int c = node.c;
        
        if(visited[a][b][c]) return;
        
        visited[a][b][c] = true;

        if(a==0){
            set.add(c);
        }
        
        // A -> B
        if (a > 0 && b < limit[1]) {
            int pour = Math.min(a, limit[1] - b);
            dfs(new Node(a - pour, b + pour, c));
        }

        // A -> C
        if (a > 0 && c < limit[2]) {
            int pour = Math.min(a, limit[2] - c);
            dfs(new Node(a - pour, b, c + pour));
        }

        // B -> A
        if (b > 0 && a < limit[0]) {
            int pour = Math.min(b, limit[0] - a);
            dfs(new Node(a + pour, b - pour, c));
        }

        // B -> C
        if (b > 0 && c < limit[2]) {
            int pour = Math.min(b, limit[2] - c);
            dfs(new Node(a, b - pour, c + pour));
        }

        // C -> A
        if (c > 0 && a < limit[0]) {
            int pour = Math.min(c, limit[0] - a);
            dfs(new Node(a + pour, b, c - pour));
        }

        // C -> B
        if (c > 0 && b < limit[1]) {
            int pour = Math.min(c, limit[1] - b);
            dfs(new Node(a, b + pour, c - pour));
        }
        
        
    }

}
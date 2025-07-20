
import java.util.*;
import java.lang.*;
import java.io.*;

class boj_1991 {

    static class Node{
        int L;
        int R;
        public Node(int L, int R){
            this.L = L;
            this.R = R;
        }
    }

    public static Queue<Integer> queue;
    public static ArrayList<Node>[] list;
    public static int[] visited;
    public static int N;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // A : 1
        // B : 2

        list = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int root = (int)st.nextToken().charAt(0) - 64;
            int left = Math.max(0, (int)st.nextToken().charAt(0) - 64);
            int right = Math.max(0, (int)st.nextToken().charAt(0) - 64);
           
            list[root].add(new Node(left, right)); 
        }

        sb = new StringBuilder();
        prev(1);
        print();
        sb = new StringBuilder();
        mid(1);
        print();
        sb = new StringBuilder();
        back(1);
        print();
    }


    public static void print(){
        System.out.println(sb.toString());
    }

    public static void prev(int index){
        
        if(index == 0) return;
        
        Node node = list[index].get(0);
        sb.append((char)(index + 64));
        prev(node.L);
        prev(node.R);
    }
    public static void mid(int index){
        
        if(index == 0) return;
        
        Node node = list[index].get(0);
        mid(node.L);
        sb.append((char)(index + 64));
        mid(node.R);
    }

    public static void back(int index){
        
        if(index == 0) return;
        
        Node node = list[index].get(0);
        back(node.L);
        back(node.R);
        sb.append((char)(index + 64));
    }

} 
import java.util.*;
import java.lang.*;
import java.io.*;

// 11:51

// 수직선 위에 N 개의 좌표가 있다. 
// 이 좌표에 좌표 압축을 적용하려고 한다. 
// 중복을 제거해서 set 에 넣은다음에 N 번 돌면서 채워넣으면 되는거 아닌가?

class boj_18870 {

    static class Node{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] arr = new Node[N];
        Node[] newArr = new Node[N];
        
        for(int i=0;i<N;i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i, value);
        }

        Arrays.sort(arr, (o1,o2) -> Integer.compare(o1.value , o2.value));

        int index =0;
        for(int i=0;i<N;i++){

            newArr[i] = new Node(arr[i].index, index);
            if(i+1 < N && arr[i+1].value != arr[i].value){
                index++;
            }
        }

        Arrays.sort(newArr, (o1,o2) -> Integer.compare(o1.index , o2.index));

        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<N;i++){
            sb.append(newArr[i].value).append(" ");    
        }

        System.out.println(sb.toString());
        
    }
}
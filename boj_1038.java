import java.util.*;
import java.lang.*;
import java.io.*;


// 음이 아닌 정수 X : 0 과 자연수.
// 가장 큰 자릿수부터 작은 자릿수까지 감소한다면 그 수는 감소하는 수. 
// 그니까 더 작아야한다 이전의 자릿수보다. 
// 0부터 시작해서 감소하는수를 찾아라. 
// N은 100만까지 있고 
// 근데 감소하는게 많을 수 있으니까
// long 까지 갈듯?
// long 으로 처리해야할 것 같고. 
// 음.. 다 해보는 수밖에 없을 것 같은데.
// 1억을 넘어갈듯
// 그럼 다 돌리는건 아닌 것 같고. 
// 아닌가 조합으로 그냥 다 돌리면/ 
// 1 2 3 4 5 6 7 8 9 최대 10억이긴하네. 
// 9,876,543,210 long 을 사용하긴 해야하고
// 
class boj_1038 {

    public static ArrayList<Long> list;
    public static int N;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // set으로 하느냐 list로 하느냐인데. 중복이 일어날 일이 없지않나? 
        // list 로 하는걸로.
        list = new ArrayList<>();
        
        dfs(0,9,"");

        list.sort(Comparator.naturalOrder());

        if(N > list.size()-1){
            System.out.println(-1);
        }
        else{
            System.out.println(list.get(N));
        }
        
    }

    public static void dfs(int count, int index, String value){

        if(count == 10){
            return;
        }

        for(int i=index; i>=0; i--){

            String next = value + i;
            list.add(Long.parseLong(next));
            dfs(count + 1, i-1, next);
        }
    }
}
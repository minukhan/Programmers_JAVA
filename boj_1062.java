import java.util.*;
import java.lang.*;
import java.io.*;


// 11:21

// 가능한한 많은 단어를 읽을 수 있도록 하려함.
// K개의 글자를 가르칠 시간밖에 없음.
// K개의 글자를 가르쳐주면 그 K개의 글자로만 이루어져있는 글만 읽을 수 있음.
// 어떤 K개를 가르쳐야 많이 단어를 읽을 수 있을까?
// 모든 단어는 anta, tica 가 들어가고 N개밖에 없음. 
// N은 50까지 있고 단어의 갯수임 단어 모두 탐색해야함. 단어는 최대 15
// 15 *
// 일단 8 빼면 최대 7개를 탐색하는데 26의 7승 말이안됨.
// 1. N개를 돌아가면서 탐색한다. 각각
// 2. 최대 7자리 수를 모두 돌아보며 탐색한다.? 돌아보면서 같은게 있다면 break?
// 2 K개 추가된 경우를 만들어놓고 set 에 넣어놓고 contains? 그럼 만약 7이면 다 만들어?
// 26의 7승을? 불가능 메모리초과 25 제곱 = 700 490,000 * 625 * 25 -> 불가능.
// 그러면 26배열을 하나 만들어서
// count 한다 ? N번을 돌면서 탐색해야하는데
// 하나를 탐색할때 다른 문자의 갯수를 탐색 = 15 후 배열에 저장. 50 * 26 배열을 만들어
// 그럼 갯수들이 쭉 나올텐데 여기서 우짜노 그러면 그거를 이제 26Ck를 해서 최대값?
// 이거가 현실성 있을듯.
// K는 26까지 있고 0도 가능.
// 모든 단어는 영어 소문자로만 이루어져있고 길이가 8 이상 15 이하임. 중복없고
// a,n,t,i,c 는 무조껀포함 그러면. 


class boj_1062 {

    public static int N;
    public static int K;
    public static int max = Integer.MIN_VALUE;
    public static int[][] count;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        count = new int[N][26];

        if(K<5){
            System.out.println(0);
            return;
        }

        arr[K-5] = 'a' - 97;
        arr[K-4] = 'n' - 97;
        arr[K-3] = 't' - 97;
        arr[K-2] = 'i' - 97;
        arr[K-1] = 'c' - 97;
        
        for(int i=0;i<N;i++){
            
            String word = br.readLine();
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                count[i][c-97] = 1;
            }
        }

        dfs(0,0);

        System.out.println(max);
    }

    public static void dfs(int count, int index){

        if(count == K-5){
            calculate();
            return;
        }
        for(int i=index;i<26;i++){

            if(i==('a'-97) || i=='n' - 97 || i=='i' - 97 ||i== 't' - 97 || i=='c' - 97) continue;
            
            arr[count] = i;
            dfs(count +1, i+1);
        }
    }

    public static void calculate(){

        int result =0;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<K;i++){
            set.add(arr[i]);
        }

        for(int i=0;i<N;i++){
            boolean check = true;
            for(int j=0;j<26;j++){
                if(count[i][j]==1 && !set.contains(j)){
                    check = false;
                    break;
                }
            }
            if(check){
                result++;
            }
        }
        max = Math.max(max, result);
    }
}

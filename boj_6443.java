import java.util.*;
import java.lang.*;
import java.io.*;



// 12:08
// 애너그램 프로그램이란 입력받은 영단어의 철자들로 만들 수 있는 모든 단어를 출력하는것
// 순서만 바꿔서 다른게있다면 다 출력하라는 뜻.
// 단어의 길이는 20보다는 작고 애너그램 수가 100,000 개이하인 단어만 주어진다.
// 단어가 몇개인지는 안알려주네..? 시간초과는 안나겠지뭐
// 약간 테스트케이스같은 느낌이고 
// 하나 들어왔을때 문자 갯수 세고? 중복을 허용하지 않는 순열임. 
// set에다 넣고 하면될듯? 근데 갯수가 정해져있는데 갯수를 어디 배열에 저장해놓고
// 26자리 배열을 만들어서 거기서 처리하는게 나을듯.
class boj_6443 {
    public static int[] arr;
    public static StringBuilder sb;
    public static HashSet<String> set;
    public static String str;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        set= new HashSet<>();
        for(int i=0;i<N;i++){
            str = br.readLine();
            arr = new int[26];
            
            for(int j=0;j<str.length();j++){
                arr[str.charAt(j) - 97]++;
            }

            dfs(0,"");

        }

        System.out.println(sb.toString());
        
    }
    public static void dfs(int count, String answer){

        if(count == str.length()){
            sb.append(answer).append("\n");
            return;
        }

        for(int i=0;i<26;i++){

            if(arr[i] <= 0) continue;

            char c = (char)(97 +i);
            
            arr[i]--;
            dfs(count+1, answer + c);
            arr[i]++;
        }
    }
}
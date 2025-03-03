import java.util.*;
import java.lang.*;
import java.io.*;

class CatLangage {

    public static int[] count;
    
    public static void CatLangage(String[] args) throws IOException{

        // count 배열을 하나 만들어서 갯수 저장.
        // L , R 에 따라서 갯수를 계속 갱신해주고

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        
        char[] cat = input.toCharArray();

        count = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();

        char alpa = 'a';
        for(int i=0;i<26;i++){
            map.put((char)(alpa + i),i);
        }


        int max = Integer.MIN_VALUE;
        int R = -1;
        
        for(int L=0;L<input.length();L++){

            if(L>0){
                count[map.get(cat[L-1])]--;
            }
            // 최대한 올릴 수 있을만큼 R 을 증가.
            while(R+1 < input.length()){
                
                R++;
                count[map.get(cat[R])]++;

                if (check() > n) {  // 초과하면 롤백
                    count[map.get(cat[R])]--;
                    R--;
                    break;
                }
                
            }
            
            if(check() <= n){
                 max = Math.max(max, R-L+1);
            }
        }

        
        
        System.out.println(max);
        
    }
    public static int check(){
        int result =0;
        
        for(int i=0;i<count.length;i++){
            if(count[i] != 0){
                result++;
            }
        }

        return result;
    }
}
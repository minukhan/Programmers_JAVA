import java.util.*;
import java.lang.*;
import java.io.*;

// 2:13

// 모기를 싫어하는 지동이는 모기가 가장 많이 있는 시간대가 언제니
// 방이 언제 입장했고 언제 퇴장했는지 기록 가능. 
// 입장, 퇴장 시간이 주어졌을 때, 가장 많이 있는 시간대와 해당시간에 몇마리가 있는지 

// 시간복잡도 : 100만개.
// 입장시간과 퇴장시간이 21억
// N log n 으로 처리해야함. 

// 누적합으로 처리하면될듯 ? 정렬한뒤에? 
// 이게 그거네. 그 구역을 전체를 저장하는법은 i 번째에 + i+K + 1 에 - 로 집어넣기. 
// 근데 이거를 하려면 배열이 21억개만큼 있어야하는데 메모리초과,
// -> 그래서 좌표압축을 이용? 
// 차이를 기억해두면 되긴 하는데. 시작지점과 차이를 기억? 
// 차이가 21억이면? 
// 차이를 압축? ㅇㅇ 차이를 압축. 
// 숫자가 말도안되게 클떄 사용.

class boj_20440 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        int[] start = new int[N];
        int[] end = new int[N];

        TreeSet<Integer> set = new TreeSet<>( (o1, o2) -> Integer.compare(o1, o2));
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int startValue = Integer.parseInt(st.nextToken());
            int endValue = Integer.parseInt(st.nextToken());

            start[i] = startValue;
            end[i] = endValue;

            set.add(startValue);
            set.add(endValue);
        }

        int index =0;
        for(int value : set){
            map.put(value , index++);
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);

        int[] dp = new int[map.size()];
        
        for(int i=0;i<N;i++){
            int startValue = map.get(start[i]);
            int endValue = map.get(end[i]);
            dp[startValue]++;
            dp[endValue]--;
        }

        for(int i=0;i<dp.length-1;i++){
            dp[i+1] += dp[i];
        }
        int max = Integer.MIN_VALUE;

        for(int i=0;i<dp.length;i++){
            max = Math.max(max, dp[i]);
        }

        int startIndex = -1;
        int endIndex = -1;

        for(int i=0;i<dp.length;i++){
            if(dp[i] == max && startIndex == -1){
                startIndex = i;
            }
            if(dp[i] != max && startIndex != -1){
                endIndex = i;
                break;
            }
        }

        if (endIndex == -1) endIndex = dp.length - 1;

        int realStartValue = list.get(startIndex);
        int realEndValue = list.get(endIndex); 

        System.out.println(max);
        System.out.println(realStartValue + " " + realEndValue);
        
    }
}

























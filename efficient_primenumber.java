// first code 75 score

// class Solution {
// public int solution(int n) {
// int answer = 0;
// int count=0;

// for(int i=2;i<=n;i++){
// for(int j=1;j*j<=i;j++){
// if(i%j==0){
// count++;
// if(j!=i/j){
// count++;
// }
// }
// }
// if(count==2){
// answer++;
// }
// count=0;
// }
// return answer;
// }


// second code 87 score

// class Solution {
// public int solution(int n) {
// int answer = 0;
// int count=0;

// boolean[] sosu = new boolean[n+1]; // 기본 초기화 값은 false

// sosu[0] = true;
// sosu[1] = true;
// for(int i=2;i<=n;i++){
// for(int j=1;j*j<=i;j++){
// if(sosu[i]==false){
// if(i%j==0){
// count++;
// if(j!=i/j){
// count++;
// }
// }
// }
// }
// if(count==2){
// answer++;
// for(int k=i;k<sosu.length;k=k+i){
// sosu[k] = true;
// System.out.println(k);
// }
// }
// count=0;
// }

// return answer;
// }
// }




class efficient_primenumber {
    public int efficient_primenumber(int n) {
        int answer = 0;
        
        boolean[] sosu = new boolean[n+1]; // 기본 초기화 값은 false
        
        sosu[0] = true;
        sosu[1] = true;
            for(int i=2;i<=n;i++){
                if(sosu[i]==false){
                    answer++;
                    for(int k=i;k<sosu.length;k=k+i){
                        sosu[k] = true;
                    }
                }  
            }
        
        return answer;
    }
}
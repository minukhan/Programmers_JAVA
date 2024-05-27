package Programmers;

class Solution {// 숨어있는 숫자의 덧셈 (1)

    public int solution(String my_string) {

        int answer = 0;

        int count=0;

        char [] a = my_string.toCharArray();

        

        for(int i=0;i<a.length;i++){

            if(a[i]=='0' || a[i]=='1'||a[i]=='2'||a[i]=='3'||a[i]=='4'||a[i]=='5'||a[i]=='6'||a[i]=='7'||a[i]=='8'||a[i]=='9'){

                count += Integer.parseInt(String.valueOf(a[i]));

            }

        }


        answer = count;


        return answer;

    }

}
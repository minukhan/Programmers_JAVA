    // class balls_int {

    //     public int balls_int(int balls, int share) {
    
    //         int answer = 0;
    
    //         //확률과 통계에 나오는 조합을 이용하는 문제
    
            
    
    //         int top=1;
    
    //         int bottom=1;
    
    //         int h = share;
    
    //         for(int i=balls;h>0;h--){
    
    //             top *= i;
    
    //             i--;
    
                
    
    //         }
    
    //         System.out.println(top);
    
            
    
    //         for(int i=share;share>0;share--){
    
    //             bottom *= share;
    
    //         }
    
    //         System.out.print(bottom);
    
    //         answer = top/bottom;
    
            
    
    //         return answer;
    
    //     }
    
    // }
    
    // 처음에는 위 코드로 단순하게 실행하였다. 하지만 int 형 범위를 고려하지 않았다.  따라서 범위를 초과하지 않도록 다시 코드를짰다.
    class balls_int {

        public double balls_int(int balls, int share) {
    
            double answer = 0;
    
            //확률과 통계에 나오는 조합을 이용하는 문제
    
            
    
            double top=1;
    
            double bottom=1;
    
            int h = share;
    
            int mid=1;
    
            
    
            if(share>15){
    
                
    
                h = balls-share;
    
                share = balls-share;
    
                
    
                for(int i=balls;h>0;h--){
    
                    top *= i;
    
                    i--;
    
                }
    
                for(int i=share;share>0;share--){
    
                    bottom *= share;
    
                }
    
                answer =  top/bottom;
    
            }
    
            else{
    
                
    
                for(int i=balls;h>0;h--){
    
                    top *= i;
    
                    i--;
    
                }
    
                for(int i=share;share>0;share--){
    
                    bottom *= share;
    
                }
    
               
    
            }
    
             answer =  top/bottom;
    
            
    
                return answer;
    
        }
    
    }


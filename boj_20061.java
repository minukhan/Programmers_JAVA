import java.util.*;
import java.lang.*;
import java.io.*;


//4: 48

// 빨강 4*4 격자모양
// 파랑 4*6 격자모양
// 초록 6*4 격자모양

// 블록은 3종류가 있는데 1*1 2*1 1*2 이렇게 3종류가 있다.
// 블록을 놓을 위치를 빨강색 보드에서 선택하면 그 위치로부터 초록색 보드로 블록이 이동?
// 그다음은 파랑색 보드로 블록이 이동 그니까 각각 이동한다. 블록이 있거나 벽에 부딛힐때까지
// 테트리스저럼 어떤 행이 타일로 가득 차있다면 그 행의 타일은 모두 사라진다. 
// 블록이 빈공간이 있으면 내려가긴하는데 한칸씩만 내려감.
// 이때 게임이 진행되면서 횟수가 주어지고 그렇게 진행되었을때 얻은 점수와 초록, 파랑의 상태

class boj_20061 {

    public static int N;
    public static int count =0;
    public static int[][] blue;
    public static int[][] green;
    
    
    public static void main(String[] args) throws IOException{

        // 1. 위치가 주어지면 그 위치에 맞게 파랑, 초록 구역으로 쭉 내려간다.
            //이때 그 상태를 계속 기록해놔야함. 
            // 어떤 자료구조를 쓸까 List, stack, queue, array 배열도 낫배드?
            // 배열이 삽입 삭제하기 편하고 검사하기도 편할듯.
            // 배열로 가고 같인 내려가야함. 
        // 2. 초록색 보드는 행이 꽉 차면 그 행의 타일은 삭제.
            // 이건 검사하는거 하나 만들면 될거같고
            // 움직이는걸 함수로 하나 만들어놓자. 오른쪽, 아래쪽
            // 그리고 그 위에있는 블럭들을 1칸씩 내린다.
        // 3. 파랑색 보드는 열이 꽉 차면 그 열의 타일은 삭제
            // 그리고 그 열을 오른쪽으로 한칸씩 옮긴다. 
        // 4. 0, 1 블럭을 내리고 난 뒤 구역에 들어오면 초록은 아래로, 파랑은 오른쪽으로 움직인다.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        green = new int[6][4];
        blue = new int[4][6];
        StringTokenizer st;
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            blueMove(input, x, y);
            greenMove(input, x, y);
        }

        System.out.println(count);
        calculation();
        
    }

    public static void calculation(){
        int result = 0;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                if(blue[i][j] == 1) result++;
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                if(green[j][i] == 1) result++;
            }
        }

        System.out.println(result);
    }

    public static void moveR(int end){
        for(int i=end-1;i>=0;i--){
            for(int j=0;j<4;j++){
                blue[j][i+1] = blue[j][i];
            }
        }
        for(int i=0;i<4;i++){
            blue[i][0] = 0;
        }
    }

    public static void moveD(int end){
        for(int i=end-1;i>=0;i--){
            for(int j=0;j<4;j++){
                green[i+1][j] = green[i][j];
            }
        }
        for(int i=0;i<4;i++){
            green[0][i] = 0;
        }
    }

    public static void blueCheck(){ 

        for(int i=5;i>0;i--){
            boolean empty = false;
            
            for(int j=0;j<4;j++){
                if(blue[j][i] == 0){
                    empty = true;
                }
            }

            if(!empty){
                moveR(i);
                count++;
                i++;
            }
        }
    }

    public static void greenCheck(){ 

        for(int i=5;i>0;i--){
            boolean empty = false;
            
            for(int j=0;j<4;j++){
                if(green[i][j] == 0){
                    empty = true;
                }
            }

            if(!empty){
                moveD(i);
                count++;
                i++;
            }
        }
    }

    public static boolean cleanBlueArea(){
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                if(blue[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static boolean cleanGreenArea(){
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                if(green[j][i] == 1) return false;
            }
        }
        return true;
    }


    public static void greenMove(int index, int x, int y){

        int currentX =-1;
        int currentY =-1;
        
        if( index == 1){ // 1*1 
            currentX = x;
            currentY = 0;
            
            while(true){
                if(currentY + 1 == 6){// 벽이거나
                    break;
                }
                if(green[currentY+1][currentX] == 1){ //블럭이 있거나
                    break;
                }
                currentY++;
            }

            green[currentY][currentX] = 1;
            
            // 블럭이 깨지는게 있는지 확인한다.
            greenCheck();

            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanGreenArea()){
                moveD(5);
            }
        }
        else if(index ==3){
            currentX = x;
            currentY = 0;
            
            while(true){
                if(currentY + 1 == 6){// 벽이거나
                    break;
                }
                if(green[currentY + 1][currentX] == 1 || green[currentY + 1][currentX + 1] == 1){ //블럭이 있거나
                    break;
                }
                currentY++;
            }

            green[currentY][currentX] = 1;
            green[currentY][currentX+1] = 1;

            // 블럭이 깨지는게 있는지 확인한다.
            greenCheck();
            

            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanGreenArea()){
                moveD(5);
            }
        }
        else{

            currentX = x;
            currentY = 0;

            while(true){
                if(currentY + 1 == 6){// 벽이거나
                    break;
                }
                if(green[currentY+1][currentX] == 1){ //블럭이 있거나
                    break;
                }
                currentY++;
            }

            
            green[currentY][currentX] = 1;
            green[currentY-1][currentX] = 1;

            // 블럭이 깨지는게 있는지 확인한다.
            greenCheck();
            

            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanGreenArea()){
                moveD(5);
            }
        }
    }

    public static void blueMove(int index, int x, int y){

        int currentX =-1;
        int currentY =-1;
        
        if( index == 1){ // 1*1 
            currentX = 0;
            currentY = y;

            while(true){
                if(currentX + 1 == 6){// 벽이거나
                    break;
                }
                if(blue[currentY][currentX + 1] == 1){ //블럭이 있거나
                    break;
                }
                currentX++;
            }

            // 블럭을 놓는다.
            blue[currentY][currentX] = 1;
            // 블럭이 깨지는게 있는지 확인한다.
            blueCheck();
            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanBlueArea()){
                moveR(5);
            }
        }
        else if(index ==3){
            currentX = 0;
            currentY = y;
            
            while(true){
                if(currentX + 1 == 6){// 벽이거나
                    break;
                }
                if(blue[currentY][currentX + 1] == 1){ //블럭이 있거나
                    break;
                }
                currentX++;
            }

            blue[currentY][currentX] = 1;
            blue[currentY][currentX-1] = 1;

            // 블럭이 깨지는게 있는지 확인한다.
            blueCheck();
            

            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanBlueArea()){
                moveR(5);
            }
        }
        else{

            currentX = 0;
            currentY = y;

            while(true){
                if(currentX + 1 == 6){// 벽이거나
                    break;
                }
                if(blue[currentY][currentX + 1] == 1 || blue[currentY + 1][currentX + 1] == 1){ //블럭이 있거나
                    break;
                }
                currentX++;
            }

            
            blue[currentY][currentX] = 1;
            blue[currentY+1][currentX] = 1;

            // 블럭이 깨지는게 있는지 확인한다.
            blueCheck();
            

            // 다 확인했으면 이 구역이 0,1 인지 확인한다.
            while(!cleanBlueArea()){
                moveR(5);
            }
        }
    }
}
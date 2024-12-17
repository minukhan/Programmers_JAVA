class predictFight
{
    public int predictFight(int n, int a, int b)
    {
        int answer =0;
        int count =0;
        
        while(true){
            a = (a + 1 )/ 2 ;
            b = (b + 1 )/ 2 ;
            count++;
            
            if(a==b){
                answer = count;
                break;
            }
        }

        return answer;
    }
}
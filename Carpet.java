class Carpet {
    public int[] Carpet(int brown, int yellow) {
        
        int y = 0;
        int x =0;
        for(int i=1;i<2000000;i++){
            if((((2 * (yellow + brown) / i) + 2*i) -4) ==  brown && (yellow + brown) % i == 0 ){
                y = i;
                break;
            }
        }
        
        x =  (brown - 2*y +4)/2;
        
        int[] answer = {x,y};
        
            
        return answer;
    }
}
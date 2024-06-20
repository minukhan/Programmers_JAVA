class triangle2 {
    public int triangle2(int[] sides) {
        int answer = 0;
        
        int bignum = 0;
        int smallnum=0;
        int count =0;
        
        if(sides[0]>sides[1]){
            bignum = sides[0];
            smallnum = sides[1];
        }
        else{
            bignum = sides[1];
            smallnum = sides[0];
        }
        
        for(int i=bignum-smallnum+1;i<bignum;i++){
            answer++;
        }
        for(int i=bignum;i<bignum+smallnum;i++){
            answer++;
        }
        
        
        return answer;
    }
}
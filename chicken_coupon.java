class chicken_coupon {
    public int chicken_coupon(int chicken) {
        int answer = 0;
        int coupon =0;
        int coupon2 =0;
        
        while(chicken>0){
            answer += chicken/10;
            coupon += chicken%10;
            chicken = chicken/10;
            System.out.println(chicken);
            
        }
        
        while(coupon>9){
            coupon += coupon%10;
            answer += coupon/10;
            coupon = coupon/10;
        }
        
        return answer;
    }
}
class bandage {
    public int bandage(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int currentTime=0;
        int countTime = 0;
        int currentHealth = health;
        
        int RecoveryTime = bandage[0];
        int RecoveryOneTime =  bandage[1];
        int RecoveryPlus =  bandage[2];
        
        for(int i=0;i<attacks.length;i++){
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            
            
            while(attackTime>currentTime){
               
                currentTime++;
                countTime++;
                currentHealth+= RecoveryOneTime;
                
                if(countTime==RecoveryTime){
                    currentHealth+= RecoveryPlus;
                    countTime =0;
                }
                if(currentHealth>health){
                    currentHealth = health;
                }
                
                
            }
                System.out.println("i : "+ i);
            
            System.out.println("맞기전 체력 currentHealth : "+ currentHealth);
            System.out.println(" damage : "+ damage);
            
            currentHealth = currentHealth - damage;
            countTime=0;
            currentTime++; 
            
            System.out.println("currentTime : "+ currentTime);
                System.out.println("countTime : "+ countTime);
                System.out.println("attackTime : "+ attackTime);
                System.out.println("currentHealth : "+ currentHealth);
            
            
            if(currentHealth<=0){
                break;
            }
        }
        if(currentHealth<=0){
            answer = -1;
        }
        else{
            answer = currentHealth;
        }
    
        return answer;
    }
}
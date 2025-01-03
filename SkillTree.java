class SkillTree {
    public int SkillTree(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillArr = skill.toCharArray();
        char cc = 'C';
        
        for(int i=0;i<skill_trees.length;i++){
            int index = 0;
            boolean check = true;
            
            for(int j=0;j<skill_trees[i].length();j++){
                
                if(skill.contains(String.valueOf(skill_trees[i].charAt(j)))){
                    if(index<skillArr.length && skillArr[index]==skill_trees[i].charAt(j)){
                        index++;
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }
            
            if(check){
                answer++;
            }
            
        }
        
        return answer;
    }
}
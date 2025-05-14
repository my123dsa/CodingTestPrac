class Solution {
    char[] skillArray;
    int count=0;
    public int solution(String skill, String[] skill_trees) {
        skillArray= skill.toCharArray();

        for(int i=0;i<skill_trees.length;i++){
            char[] nowSkill =skill_trees[i].toCharArray();

            function(nowSkill);

        }

        return count;
    }
    public void function(char[] nowSkill){
        int index=0;
        int check=0;
        while(check<skillArray.length){
            char skill= skillArray[check];
            while(index<nowSkill.length){
                char now = nowSkill[index];
                if(now==skill){
                    check++;
                    index++;
                    break;
                }
                else{
                    for(int k=check+1;k<skillArray.length;k++){
                        if(now== skillArray[k]){
                            return;
                        }
                    }
                    index++;
                }
            }
            if(index==nowSkill.length){
                break;
            }
        }
        count++;
    }
}
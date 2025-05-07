class Solution {
    int[] discount ={10,20,30,40};
    int[][] USERS;
    int[] EMOTICONS;
    int maxCount=0;
    int maxTotal=0;
    public int[] solution(int[][] users, int[] emoticons) {
        USERS= users;
        EMOTICONS= emoticons;
        dfs(new int[emoticons.length],0);
        int[] answer = new int[2];
        answer[0]= maxCount;
        answer[1]= maxTotal;
        return answer;
    }

    public void dfs(int[] discounts,int depth){
        if(depth==discounts.length){
            check(discounts);
            return;
        }
        for(int i : discount){
            discounts[depth]= i;
            dfs(discounts,depth+1);
        }
    }

    public void check(int[] discounts){
        int count=0;
        int total=0;

        for (int i=0;i<USERS.length;i++){
            int tempt=0;
            int[] user = USERS[i];
            for(int j=0;j<discounts.length;j++){
                if(user[0]<=discounts[j]){
                    int price= (int) EMOTICONS[j]*(100-discounts[j])/100;
                    tempt+=price;
                }
            }
            if(tempt>=user[1]){
                count++;
            }else{
                total+=tempt;
            }
        }
        if(maxCount<count){
            maxCount=count;
            maxTotal= total;
        }
        else if(maxCount== count){
            maxTotal=Math.max(maxTotal,total);
        }
    }
}
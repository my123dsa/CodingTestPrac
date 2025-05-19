class Solution {
    public int[] solution(int n, int s) {
        //최대 값은 n등분 했을 때
        //1. s<n일경우
        if(s<n){
            return new int[]{-1};
        }
        int ahr= s/n;
        int skajwl = s%n;
        int[] answer = new int[n];

        for(int i=0;i<n;i++){
            // System.out.println(i+" "+skajwl);
            if(i>=n-skajwl){
                answer[i]= ahr+1;
            }
            else{
                answer[i] = ahr;
            }
        }
        return answer;
    }
}
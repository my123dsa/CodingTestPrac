class Solution {
    int level =0;
    int N ;
    int[][] array;
    int x=0;
    int y=0;
    int total=0;
    int[] answer;
    int index=1;
    public int[] solution(int n) {
        array= new int[n][];
        N= n;
        total = n*(n+1)/2;
        int[] answer= new int[total];
        for(int i=0;i<n;i++){
            array[i]= new int[i+1];
        }
        if(n==1){
            return new int[]{1};
        }
        funcFirst();

        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<array[i].length;j++){
                answer[k++] = array[i][j];
            }
        }

        return answer;
    }

    public void funcFirst(){

        while(index!=total+1){
            while(x<N-level-1){
                array[x++][y]= index++;
            }

            while(y<x-level){
                array[x][y++]= index++;
            }

            level++;

            while(array[x][y]==0){
                array[x--][y--]= index++;
            }

            x+=2;
            y++;
        }
    }
}
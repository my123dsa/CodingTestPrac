import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {

        int total= brown + yellow;
        //48
        // 3,4,6,8,12,16 ... ,24,48
        // 무조건 3이상
        // 3, 16-> 노란색 최소 1 ~ 16-2=14
        // 4, 12-> 노란색 최소 2 ~ 2*10 = 20
        // 6 8 -> 노란색 최소  4 ~ 4*6 = 24  , 6*2+8*2-2
        List<Integer> list= new ArrayList<>();
        List<Integer> bigList = new ArrayList<>();
        for(int i=3;i*i<=total;i++){
            if(total%i ==0){
                list.add(i);
                bigList.add(total/i);
            }
        }
        int r=0;
        int c=0;
        for(int i=0;i<list.size();i++){
            int row=list.get(i);
            int col= bigList.get(i);

            int brownCount=row*2+col*2 -4;
            //33
            int yellowCount=(row-2)*(col-2);
            if(yellowCount==yellow && brownCount==brown){
                r= row;
                c= col;
                break;
            }
        }
        int[] answer = new int[2];
        answer[0]=c;
        answer[1]=r;
        // System.out.println(list);
        // System.out.println(bigList);

        return answer;
    }
}

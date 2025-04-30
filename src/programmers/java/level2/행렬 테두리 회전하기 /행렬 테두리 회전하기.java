import java.util.*;
class Solution {
    int[][] array;
    int[] query;
    List<Integer> list;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        array = createArray(rows,columns);
        for(int i=0;i<queries.length;i++){
            list= new ArrayList<>();
            query = queries[i];
            int[] now = new int[2];
            now[0]= query[0];
            now[1] =query[1];
            int first= func(now,array[now[0]-1][now[1]-1]);

            now[0]= query[2];
            now[1]= query[3];
            int last =funcReverse(now,first);
            array[query[0]-1][query[1]-1]=last;
            list.add(last);
            Collections.sort(list);
            answer[i]=list.get(0);
        }

        //위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열
        return answer;
    }

    public int func(int[] now,int before){
        if(now[0]==query[2] && now[1]== query[3]){
            return before;
        }

        int temp = array[now[0]-1][now[1]-1];
        list.add(before);
        array[now[0]-1][now[1]-1] = before;
        before = temp;

        if(now[1]<query[3]){
            now[1]++;
        }else if(now[0]<query[2]){
            now[0]++;
        }

        return func(now,before);
    }
    public int funcReverse(int[] now,int before ){

        if(now[0]==query[0] && now[1]== query[1]){
            return before;
        }
        int temp = array[now[0]-1][now[1]-1];
        list.add(before);
        array[now[0]-1][now[1]-1] = before;
        before = temp;

        if(now[1]>query[1]){
            now[1]--;
        }else if(now[0]>query[0]){
            now[0]--;
        }

        return funcReverse(now,before);
    }

    public int[][] createArray(int rows,int columns){
        int[][] array = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                array[i][j]= i*columns+ j+1;
                // System.out.println(array[i][j]);
            }
        }
        return array;
    }
}
import java.util.*;
class Solution {
    int[][] array;
    public int[] solution(String s) {
        String str= s.substring(1,s.length()-1);
        init(str);
        int index=0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] answer  = new int[array.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                int num =array[i][j];
                if(!map.containsKey(num)){
                    map.put(num,index);
                    answer[index++]=num;
                    break;
                }
            }
        }


        return answer;
    }

    public void init(String str){
        String[] sArray =str.split("},");
        for(int i=0;i<sArray.length;i++){
            if(i!=sArray.length-1){
                sArray[i]=  sArray[i].substring(1, sArray[i].length());
            }
            else{
                sArray[i]=  sArray[i].substring(1, sArray[i].length()-1);
            }
        }
        Arrays.sort(sArray,(a,b)->a.length()-b.length());

        array= new int[sArray.length][];
        for(int i=0;i<sArray.length;i++){
            String[] nowArray= sArray[i].split(",");
            array[i]=new int[nowArray.length];
            for(int j=0;j<nowArray.length;j++){
                array[i][j]= Integer.parseInt(nowArray[j]);
            }
        }
    }
}
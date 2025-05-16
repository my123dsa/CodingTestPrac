import java.util.*;
class Solution {

    public int solution(int[] arr) {

        int total=1;
        int i=2;
        while(i<=100){

            List<Integer> list= new ArrayList<>();

            for(int j=0;j<arr.length;j++){
                int num = arr[j];

                if(num/i>0 && num%i==0){
                    list.add(j);
                }
            }

            if(list.size()>=2){
                total*=i;

                for(int k=0;k<list.size();k++){
                    int index= list.get(k);
                    arr[index]/=i;
                }
                i=2;
            }else{
                i++;
            }

        }

        for(int x=0;x<arr.length;x++){
            total*=arr[x];
        }

        return total;
    }
}


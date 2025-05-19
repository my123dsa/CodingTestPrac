import java.util.*;

class Solution {
    int num;
    public long solution(int n, int[] works) {
        //피로도  = 남은 작업량 ^ 2
        //가장 균일 할 때가 최소
        int len = works.length;

        //1단계 정렬 ok
        Arrays.sort(works);
        num = n;

        // System.out.println(Arrays.toString(works));

        int index=len-1;
        //모든 값이 평평하게 만드는 로직
        while(num>0 && index>0){
            index= function(works,index);
        }

        // System.out.println(Arrays.toString(works));

        //평탄화 끝났는데 num 남을 경우 균일하게 값 빼기
        // if(num>0){
        //     int idx=len-1;
        //     while(num>0){
        //         if(idx==-1){
        //             idx= len-1;
        //         }
        //         if(works[idx]==0){
        //             break;
        //         }
        //         works[idx]-=1;
        //         idx--;
        //         num--;
        //     }
        if(num>0){
            int ahr =num/len;
            int skajwl = num%len;

            for(int i=0;i<len;i++){
                if(i<skajwl){
                    if(works[i]<ahr+1){
                        works[i]=0;
                    }else{
                        works[i]-=ahr+1;
                    }
                }
                if(works[i]<ahr){
                    works[i]=0;
                }
                else{
                    works[i]-=ahr;
                }

            }
        }

        // System.out.println(Arrays.toString(works));
        // System.out.println(num);
        long answer = 0;

        //값 계산
        for(int i=0;i<len;i++){
            answer+= Math.pow(works[i],2);
        }

        return answer;
    }

    public int function(int[] works, int index){

        int minus =works[index]-works[index-1];
        if( (works.length-index)*minus>num){
            while(true){
                for(int i=works.length-1;i>=index;i--){
                    if(num==0){
                        return -1;
                    }
                    works[i]--;
                    num--;
                }

            }
        }

        for(int i= works.length-1;i>=index;i--){
            if(num<minus){
                works[i]= works[i]-num;
                num-=num;
                return -1;
            }
            works[i]= works[i]-minus;
            num-=minus;
        }
        return index-1;
    }
}